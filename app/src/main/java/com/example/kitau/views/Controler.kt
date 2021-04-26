package com.example.kitau.views

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.kitau.Main
import com.example.kitau.R
import com.example.kitau.ui.home.snackisnacki
import com.google.firebase.auth.FirebaseAuth

class Controler : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_controler)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        auth = FirebaseAuth.getInstance()
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_notifications,
                R.id.lista_ricette

                //  R.layout.l
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_options, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.exit -> {
                auth.signOut()
                snackisnacki("sessione chiusa")

                val messaggio: String = "sei uscito dalla sessione"
                val intent = Intent(this, Main::class.java).apply {
                    putExtra("m", messaggio)
                }
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }


}