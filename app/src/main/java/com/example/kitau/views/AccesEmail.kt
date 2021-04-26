package com.example.kitau.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.kitau.databinding.ActivityAccesEmailBinding
import com.google.firebase.auth.FirebaseAuth

class AccesEmail : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = FirebaseAuth.getInstance()

        val binding = ActivityAccesEmailBinding.inflate(layoutInflater)

        with(binding) {
            buttonAcces.setOnClickListener {
                val email = emailAcces.text.toString()
                val password = paswordAcces.text.toString()
                acces(email = email, password = password)
            }
        }
        setContentView(binding.root)

    }

    private fun acces(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("g", "signInWithEmail:success")
                    val user = auth.currentUser
                    Toast.makeText(this, " e iut bon!!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(baseContext, Controler::class.java))
                    //updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("TAG", "signInWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                    //updateUI(null)
                }
            }
    }
}