package com.example.trabalho32

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.trabalho32.adapter.ObrasAdapter
import com.example.trabalho32.databinding.FragmentListaObrasBinding
import com.example.trabalho32.model.Obras


class ListaObras : Fragment() {

    private lateinit var binding: FragmentListaObrasBinding
    private lateinit var obrasAdapter: ObrasAdapter
    private val listaObras = mutableListOf<Obras>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListaObrasBinding.inflate(inflater, container, false)
        val view = binding.root

        view.findViewById<Button>(R.id.btvoltar).setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_listaObras_to_inicioo)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSearchView()
        val cadastro = arguments?.getString("cadastro")

        binding.txtNomeUsuario.text = "Bem-vindo(a)"
        val recyclerViewObras = binding.recyclerViewObras
        recyclerViewObras.layoutManager = GridLayoutManager(requireContext(), 2)
        getObras()
        obrasAdapter = ObrasAdapter(requireContext(), listaObras)
        recyclerViewObras.setHasFixedSize(true)
        recyclerViewObras.adapter = obrasAdapter
    }

    private fun initSearchView() {
        binding.pesquisa.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                Log.d("SimpleSearchView", "Submit:$query")
                return false
            }

            override fun onQueryTextChange(query: String): Boolean {
                Log.d("SimpleSearchView", "Submit:$query")
                return false
            }
        })

        binding.pesquisa.setOnSearchClickListener {
        }

        binding.pesquisa.setOnCloseListener {
            obrasAdapter.clearSearch()
            true
        }
    }

    private fun getObras() {
        val obras1 = Obras(R.drawable.pint1, "Amor e Ódio")
        listaObras.add(obras1)

        val obras2 = Obras(R.drawable.pint2, "Luz na Escuridão")
        listaObras.add(obras2)

        val obras3 = Obras(R.drawable.pint3,"Um dia com Ela")
        listaObras.add(obras3)

        val obras4 = Obras(R.drawable.pint4,"Idas e Vindas")
        listaObras.add(obras4)
    }
}