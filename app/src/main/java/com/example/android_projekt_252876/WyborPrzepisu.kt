package com.example.android_projekt_252876

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat

class WyborPrzepisu : AppCompatActivity() {

    //private lateinit var przekaski: Button
    //private lateinit var obiad: Button
    //private lateinit var deser: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wybor_przepisu)

        val actionBar = supportActionBar
        actionBar!!.title = "Wybór przepisu"
        window.statusBarColor = ContextCompat.getColor(this, R.color.teal_700)
    }

    fun clickPrzekaski(view: View){
        val intent = Intent(this,ListaPrzepisow::class.java).apply {
            putExtra("danie", "Przekaski")
        }
        startActivity(intent)
    }

    fun clickObiad(view: View){
        val intent = Intent(this,ListaPrzepisow::class.java).apply {
            putExtra("danie", "Obiad")
        }
        startActivity(intent)
    }

    fun clickDeser(view: View){
        val intent = Intent(this,ListaPrzepisow::class.java).apply {
            putExtra("danie", "Deser")
        }
        startActivity(intent)
    }
}