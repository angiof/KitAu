package com.example.kitau

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kitau.databinding.ActivityMainBinding
import com.example.kitau.views.AccesEmail
import com.example.kitau.views.Controler
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth


class Main : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
// ...
// Initialize Firebase Auth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
// Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()


        val binding =ActivityMainBinding.inflate(layoutInflater)

        //snackisnacki(ricevemessagio.toString())
        with(binding) {





            signUpButton.setOnClickListener {
                //  Toast.makeText(this@Main, "fattop", Toast.LENGTH_SHORT).show()
                var email = email.text.toString()
                var pasword = password.text.toString()

                createUserWithEmail(email, pasword)


            }

            signInButton.setOnClickListener {
                startActivity(Intent(this@Main, AccesEmail::class.java))
            }


        }
        setContentView(binding.root)


    }

    private fun createUserWithEmail(email: String, pasword: String) {

        auth!!.createUserWithEmailAndPassword(email, pasword).addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information
                Log.d("g", "createUserWithEmail:success")
                Toast.makeText(this, "fatto", Toast.LENGTH_SHORT).show()
                val user = auth.currentUser
                startActivity(Intent(this,Controler::class.java))

                //updateUI(user)
            } else {
                // If sign in fails, display a message to the user.
                Log.w("g", "createUserWithEmail:failure", task.exception)
                Toast.makeText(baseContext, "Authentication failed.",
                    Toast.LENGTH_SHORT).show()
                //updateUI(null)
            }
        }
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth?.currentUser
        if (currentUser != null) {
            Toast.makeText(this, "eri gia loggato", Toast.LENGTH_SHORT).show()
            val snackbar: View
            startActivity(Intent(this, Controler::class.java))
        } else {
            Toast.makeText(this, "da accedere", Toast.LENGTH_SHORT).show()
        }
    }

}






