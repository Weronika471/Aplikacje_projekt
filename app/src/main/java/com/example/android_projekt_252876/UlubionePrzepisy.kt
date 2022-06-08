package com.example.android_projekt_252876

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.core.content.ContextCompat

class UlubionePrzepisy : AppCompatActivity() {

    private val arrayListPrzekaski= ArrayList<String>()
    private val arrayListObiady = ArrayList<String>()
    private val arrayListDesery = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ulubione_przepisy)

        val actionBar = supportActionBar
        actionBar!!.title = "Ulubione przepisy"
        window.statusBarColor = ContextCompat.getColor(this, R.color.teal_700)

        var helper=DataBaseHelper(applicationContext)
        var db=helper.readableDatabase
////////////////////////////////////////////////////////////////////////////////////////////////////////////
        var query1=db.rawQuery("SELECT * FROM ULUBIONE WHERE TYPPRZEPISU='przekaska'",null)
        while(query1.moveToNext()) {
            var dania1=query1.getString(1)
            arrayListPrzekaski.add(dania1)
        }
        val adapter1: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayListPrzekaski)
        val listView1=findViewById<ListView>(R.id.przekaskilista1)
        listView1.adapter = adapter1
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        var query2=db.rawQuery("SELECT * FROM ULUBIONE WHERE TYPPRZEPISU='obiad'",null)
        while(query2.moveToNext()) {
            var dania2=query2.getString(1)
            arrayListObiady.add(dania2)
        }
        val adapter2: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayListObiady)
        val listView2=findViewById<ListView>(R.id.obiadylista1)
        listView2.adapter = adapter2
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        var query3=db.rawQuery("SELECT * FROM ULUBIONE WHERE TYPPRZEPISU='deser'",null)
        while(query3.moveToNext()) {
            var dania3=query3.getString(1)
            arrayListDesery.add(dania3)
        }
        val adapter3: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayListDesery)
        val listView3=findViewById<ListView>(R.id.deserylista1)
        listView3.adapter = adapter3
    }
}