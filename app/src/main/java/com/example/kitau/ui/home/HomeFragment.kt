package com.example.kitau.ui.home

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.kitau.R
import com.example.kitau.databinding.FragmentHomeBinding
import com.google.firebase.auth.FirebaseAuth

class HomeFragment : Fragment() {

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {




        auth = FirebaseAuth.getInstance()
        val binding=FragmentHomeBinding.inflate(layoutInflater)


        with(binding){
          //  Glide.with(requireActivity()).load(auth.currentUser.photoUrl.toString()).into(imageViewUserLog)
            idUser.text=auth.currentUser.providerId.toString()

            if (idUser.text.equals("firebase")){
                Toast.makeText(activity, "si [ firebase", Toast.LENGTH_SHORT).show()
            }

            textHome.text=auth.currentUser.email.toString()
         //ime   userVerifica.text=auth.currentUser.isEmailVerified.toString()

        }

        return binding.root
    }
}

