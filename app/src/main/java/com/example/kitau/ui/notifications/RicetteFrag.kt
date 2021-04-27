package com.example.kitau.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kitau.databinding.FragmentNotificationsBinding

class RicetteFrag : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentNotificationsBinding.inflate(layoutInflater)
        var array=ArrayList<RicettePojo>()
        array.add(RicettePojo("angelo"))
        array.add(RicettePojo("angelo"))
        array.add(RicettePojo("angelo"))
        val viewAdapterRicetta:RecyclerView.Adapter<*>
        val layoutManager=LinearLayoutManager(requireActivity(),LinearLayoutManager.VERTICAL,false)
        viewAdapterRicetta=AdapterRicetta(array,requireActivity())

        with(binding) {
            recy.setHasFixedSize(true)
            recy.layoutManager=layoutManager
            recy.adapter=viewAdapterRicetta


            }




        return binding.root

    }
}