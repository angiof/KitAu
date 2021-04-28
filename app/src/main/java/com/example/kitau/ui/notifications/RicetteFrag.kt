package com.example.kitau.ui.notifications

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dbtester.db.RicettaEntity
import com.example.kitau.R
import com.example.kitau.databinding.FragmentNotificationsBinding

import com.example.kitau.databinding.FragmentCustomDialogBinding
import com.example.kitau.db.DBLocale
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RicetteFrag : Fragment() {


    private var db: DBLocale? = null
    private var _binding: FragmentNotificationsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
populateAdapter()
        _binding = FragmentNotificationsBinding.inflate(layoutInflater)
        binding.swipppeer.setOnRefreshListener { populateAdapter()
            binding.swipppeer.isRefreshing=false

        }
        return binding.root

    }

    var array: Array<RicettaEntity> = emptyArray()
    var adapteRecy: AdapteRecy = AdapteRecy()
    override fun onStart() {
        super.onStart()

        activity?.let { activity ->

            db = DBLocale.invoke(activity)
            val layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            val gridLayoutManager =
                    LinearLayoutManager(requireContext(), GridLayoutManager.HORIZONTAL, false)
            binding.recy.setHasFixedSize(true)
            // recyclerView.layoutManager = layoutManager
            binding.recy.layoutManager = layoutManager

            binding.recy.adapter = adapteRecy



        }
    }

     fun populateAdapter() {
        GlobalScope.launch(Dispatchers.Main) {
            array = db?.DaoRicette()?.getAll() as Array<RicettaEntity>


            Toast.makeText(requireContext(), "fatto", Toast.LENGTH_SHORT).show()
            adapteRecy.itemsList = array

        }
    }


    companion object {
        val FRAGMENT_TAG: String = "Fragutil"

        @JvmStatic
        fun newInstance() = RicetteFrag()
    }
}



class InsertDialogFragment : DialogFragment() {

    private lateinit var binding: FragmentCustomDialogBinding
    private var db: DBLocale? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentCustomDialogBinding.inflate(layoutInflater)

        binding.buttonOk.setTransformationMethod(null)
        binding.buttonCancel.setTransformationMethod(null)

        funButton()
        return binding.root
    }
    private fun funButton() {

        binding.buttonOk.setOnClickListener {
            GlobalScope.launch(Dispatchers.Main) {
                db = DBLocale.invoke(requireActivity())
                db?.DaoRicette()?.insertAll(                 RicettaEntity(titolo = binding.textTitle.text.toString(),descrizione = binding.textDescription.text.toString(),tempo = Integer.parseInt(binding.textTime.text.toString()))
                )




            }


            dismiss()
        }
        binding.buttonCancel.setOnClickListener {
dismiss()


        }

    }

    override fun onStart() {
        super.onStart()

        val dialog = dialog

        if (dialog != null) {
            val dm = DisplayMetrics()
            requireActivity().windowManager.defaultDisplay.getMetrics(dm)
            if (dialog.window != null) {
                dialog.window!!.setLayout((dm.widthPixels * 0.9).toInt(), ViewGroup.LayoutParams.WRAP_CONTENT)
                dialog.window!!.setBackgroundDrawableResource(R.color.transparent)

            }
        }
    }





}