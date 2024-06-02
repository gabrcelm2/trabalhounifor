package com.example.trabalho32

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.trabalho32.databinding.FragmentFuncionarioBinding
import com.google.android.material.snackbar.Snackbar

class Funcionario : Fragment() {

    private lateinit var binding: FragmentFuncionarioBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFuncionarioBinding.inflate(inflater, container, false)

        binding.btLogin.setOnClickListener {
            val cadastro = binding.editCadastro.text.toString()
            val senha = binding.editSenha.text.toString()

            when {
                cadastro.isEmpty() -> {
                    mensagem(it, "Preencha o campo de cadastro!")
                }
                senha.isEmpty() -> {
                    mensagem(it, "Preencha o campo de senha!")
                }
                senha.length < 6 -> {
                    mensagem(it, "A senha deve ter pelo menos 6 caracteres!")
                }
                else -> {
                    val intent = Intent(requireContext(), MainActivityFunc::class.java)
                    intent.putExtra("cadastro", cadastro)
                    startActivity(intent)
                }
            }
        }

        return binding.root
    }

    private fun mensagem(view: View, mensagem: String) {
        val snackbar = Snackbar.make(view, mensagem, Snackbar.LENGTH_SHORT)
        snackbar.setBackgroundTint(Color.parseColor("#FF0000"))
        snackbar.setTextColor(Color.parseColor("#FFFFFF"))
        snackbar.show()
    }

}