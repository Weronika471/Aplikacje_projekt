package com.example.android_projekt_252876

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.core.content.ContextCompat

class OstatniePrzepisy : AppCompatActivity() {

    private val arrayListPrzekaski= ArrayList<String>()
    private val arrayListObiady = ArrayList<String>()
    private val arrayListDesery = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ostatnie_przepisy)

        val actionBar = supportActionBar
        actionBar!!.title = "Ostatnie przepisy"
        window.statusBarColor = ContextCompat.getColor(this, R.color.teal_700)

        var helper=DataBaseHelper(applicationContext)
        var db=helper.readableDatabase
////////////////////////////////////////////////////////////////////////////////////////////////////////////
        var query1=db.rawQuery("SELECT * FROM OSTATNIE WHERE TYPPRZEPISU='przekaska'",null)
        while(query1.moveToNext()) {
            var dania1=query1.getString(1)
            arrayListPrzekaski.add(dania1)
        }
        val adapter1: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayListPrzekaski)
        val przekaskilista=findViewById<ListView>(R.id.przekaskilista)
        przekaskilista.adapter = adapter1
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        var query2=db.rawQuery("SELECT * FROM OSTATNIE WHERE TYPPRZEPISU='obiad'",null)
        while(query2.moveToNext()) {
            var dania2=query2.getString(1)
            arrayListObiady.add(dania2)
        }
        val adapter2: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayListObiady)
        val obiadylista=findViewById<ListView>(R.id.obiadylista)
        obiadylista.adapter = adapter2
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        var query3=db.rawQuery("SELECT * FROM OSTATNIE WHERE TYPPRZEPISU='deser'",null)
        while(query3.moveToNext()) {
            var dania3=query3.getString(1)
            arrayListDesery.add(dania3)
        }
        val adapter3: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayListDesery)
        val deserylista=findViewById<ListView>(R.id.deserylista)
        deserylista.adapter = adapter3
    }
}