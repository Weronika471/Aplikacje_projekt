package com.example.android_projekt_252876

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)
    }

    fun dodajPrzepis(view: View){
        val intent = Intent(this,WyborPrzepisu::class.java)
        startActivity(intent)
    }

    fun ulubione(view: View){
        val intent = Intent(this,UlubionePrzepisy::class.java)
        startActivity(intent)
    }

    fun ostatnioGotowane(view: View){
        val intent = Intent(this,OstatniePrzepisy::class.java)
        startActivity(intent)
    }
}