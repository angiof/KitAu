package com.example.kitau.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kitau.databinding.FragmentNotificationsBinding
import com.example.kitau.db.RicettaEntity

class RicetteFrag : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentNotificationsBinding.inflate(layoutInflater)

        var array=ArrayList<RicettaEntity>()
        array.add(RicettaEntity("angelo","fagiolo magico","riso",22))
        array.add(RicettaEntity("angelo","fagiolo magico","riso",22))
        array.add(RicettaEntity("angelo","fagiolo magico","riso",22))

        val viewAdapterRicetta:RecyclerView.Adapter<*>
        val layoutManager=LinearLayoutManager(requireActivity(),LinearLayoutManager.VERTICAL,false)
        val gridLayoutManager=LinearLayoutManager(requireContext(),GridLayoutManager.VERTICAL,false)
        viewAdapterRicetta=AdapterRicetta(array,requireActivity())

        with(binding) {
            recy.setHasFixedSize(true)
          //  recy.layoutManager=layoutManager
          //  recy.layoutManager =gridLayoutManager

            recy.adapter=viewAdapterRicetta


            }




        return binding.root

    }
}