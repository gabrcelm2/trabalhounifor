package com.example.trabalho32.adapter

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.trabalho32.DescricaoPint
import com.example.trabalho32.R
import com.example.trabalho32.databinding.ObrasItemBinding
import com.example.trabalho32.model.Obras


class ObrasAdapter(private val context: Context, private val listaObras: MutableList<Obras>):
    RecyclerView.Adapter<ObrasAdapter.ObrasViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ObrasViewHolder {
        val itemLista = ObrasItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ObrasViewHolder(itemLista)
    }

    override fun getItemCount() = listaObras.size


    override fun onBindViewHolder(holder: ObrasViewHolder, position: Int) {
        holder.imgObra.setImageResource(listaObras[position].img!!)
        holder.txtObra.text = listaObras[position].nome
        holder.imgObra.setOnClickListener {
            Log.d("ContentValues", "Clico na obra : "+listaObras[position].nome)


        }
    }

    inner class ObrasViewHolder(binding: ObrasItemBinding): RecyclerView.ViewHolder(binding.root){
        val imgObra = binding.imgObra
        val txtObra = binding.txtObra

        }
    }
