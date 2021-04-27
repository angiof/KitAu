package com.example.kitau.ui.notifications

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kitau.databinding.RecyModelBinding

class AdapterRicetta(private var mdaata: ArrayList<RicettePojo>, val contex: Context?) :
    RecyclerView.Adapter<AdapterRicetta.RicetteHolder>() {

    inner class RicetteHolder(val binding: RecyModelBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterRicetta.RicetteHolder {
        return RicetteHolder(RecyModelBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    }

    override fun getItemCount(): Int=mdaata.size

    override fun onBindViewHolder(holder: AdapterRicetta.RicetteHolder, position: Int) {
        with(holder.binding){
            titoloRicetta.text=mdaata[position].nome.toString()

        }
    }


}