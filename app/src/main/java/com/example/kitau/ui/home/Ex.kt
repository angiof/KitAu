package com.example.kitau.ui.home

import android.app.Activity
import android.view.View
import com.example.kitau.R
import com.example.kitau.databinding.FragmentHomeBinding
import com.google.android.material.snackbar.Snackbar

fun reciver(inpu:String){




}

fun View.snack(message: String, duration: Int = Snackbar.LENGTH_LONG) {
    Snackbar.make(this, message, duration).show()
}


fun Activity.snackisnacki(message: CharSequence, view: View? =findViewById(R.id.container), duration: Int=Snackbar.LENGTH_LONG, action:String?=null, actionsEvent:(v:View)->Unit={}){
    if (view!=null){
        val snack = Snackbar.make(view,message,duration)
        if (!action.isNullOrEmpty()){
            snack.setAction(action,actionsEvent)
        }
        snack.show()
    }}

