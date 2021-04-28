package com.example.kitau.ui.notifications

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.dbtester.db.RicettaEntity
import com.example.kitau.R
import kotlin.properties.Delegates

class AdapteRecy(private var mdaata: Array<RicettaEntity> = emptyArray()) :
    RecyclerView.Adapter<AdapteRecy.RicetteHolder>() {


    var itemsList by Delegates.observable(mdaata) { _, _, _ -> notifyDataSetChanged() }

    //  inner class RicetteHolder(val binding: RecyModelBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapteRecy.RicetteHolder {
        return RicetteHolder(
            LayoutInflater.from(parent?.context).inflate(
                R.layout.recy_model,
                parent,
                false
            )
        )
    }


    class RicetteHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val titoloRicetta: TextView by lazy { itemView.findViewById<TextView>(R.id.titolo_ricetta) }
        val descrizioneRicetta: TextView by lazy { itemView.findViewById<TextView>(R.id.descrizione_ricetta) }
        val tempoRicetta: TextView by lazy { itemView.findViewById<TextView>(R.id.ingredienti_ricetta) }
        val cardView: CardView by lazy { itemView.findViewById<CardView>(R.id.card_view) }
        fun bindItems(item: RicettaEntity): View {
            titoloRicetta.text = item.titolo.toString()
            descrizioneRicetta.text = item.descrizione.toString()

            tempoRicetta.text = item.tempo.toInt().toString()
            cardView.setOnClickListener {
                Toast.makeText(titoloRicetta.context, item.titolo, Toast.LENGTH_SHORT).show()


            }

            return itemView
        }
    }

    override fun getItemCount(): Int = itemsList.size

    override fun onBindViewHolder(holder: AdapteRecy.RicetteHolder, position: Int) {

        holder.bindItems(itemsList[position])
//        with(holder.binding) {
//            titoloRicetta.text = mdaata[position].titolo.toString()
//            descrizioneRicetta.text = mdaata[position].descrizione.toString()
//
//            tempoRicetta.text = mdaata[position].tempo.toInt().toString()
//            cardView.setOnClickListener {
//                Toast.makeText(titoloRicetta.context, mdaata[position].titolo, Toast.LENGTH_SHORT).show()
//
//
//            }

//
    }
}


//}