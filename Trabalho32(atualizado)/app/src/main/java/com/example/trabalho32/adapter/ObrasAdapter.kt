package com.example.trabalho32.adapter

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.trabalho32.DescricaoPint
import com.example.trabalho32.DescricaoPint2
import com.example.trabalho32.DescricaoPint3
import com.example.trabalho32.DescricaoPint4
import com.example.trabalho32.R
import com.example.trabalho32.databinding.ObrasItemBinding
import com.example.trabalho32.model.Obras


class ObrasAdapter(private val context:
                   Context, private val listaObras: MutableList<Obras>) :
    RecyclerView.Adapter<ObrasAdapter.ObrasViewHolder>() {

    private var talkObras = listaObras.toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObrasViewHolder {
        val itemLista = ObrasItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ObrasViewHolder(itemLista)
    }

    override fun getItemCount() = listaObras.size

    override fun onBindViewHolder(holder: ObrasViewHolder, position: Int) {
        holder.imgObra.setImageResource(listaObras[position].img!!)
        holder.txtObra.text = listaObras[position].nome

        when (position) {
            0 -> holder.imgObra.setOnClickListener {
                val fragment = DescricaoPint()
                val fragmentManager = (context as FragmentActivity).supportFragmentManager
                fragmentManager.beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit()
            }

            1 -> holder.imgObra.setOnClickListener {
                val fragment = DescricaoPint2()
                val fragmentManager = (context as FragmentActivity).supportFragmentManager
                fragmentManager.beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit()
            }

            2 -> holder.imgObra.setOnClickListener {
                val fragment = DescricaoPint3()
                val fragmentManager = (context as FragmentActivity).supportFragmentManager
                fragmentManager.beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit()
            }

            3 -> holder.imgObra.setOnClickListener {
                val fragment = DescricaoPint4()
                val fragmentManager = (context as FragmentActivity).supportFragmentManager
                fragmentManager.beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit()
            }

        }
    }

    fun search(query: String): Boolean {
        talkObras.clear()

        if (query.isEmpty()) {
            talkObras.addAll(listaObras)
        } else {
            talkObras.addAll(listaObras.filter { it.nome!!.contains(query, true) })
        }

        notifyDataSetChanged()

        return talkObras.isEmpty()
    }


    fun clearSearch() {
        talkObras.clear()
        talkObras.addAll(listaObras)
        notifyDataSetChanged()
    }

        inner class ObrasViewHolder(binding: ObrasItemBinding) :
            RecyclerView.ViewHolder(binding.root) {
            val imgObra = binding.imgObra
            val txtObra = binding.txtObra
        }
    }