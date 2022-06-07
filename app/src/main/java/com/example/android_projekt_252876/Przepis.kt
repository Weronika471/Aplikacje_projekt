package com.example.android_projekt_252876

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.core.content.ContextCompat

class Przepis : AppCompatActivity() {

    private val arrayListRepos = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_przepis)

        supportActionBar?.hide()
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)

        val dania = intent.getStringArrayExtra("danieid")
        val danieid= dania?.get(0)

        var helper=DataBaseHelper(applicationContext)
        var db=helper.readableDatabase
        var query=db.rawQuery("SELECT * FROM OPIS WHERE OPISID ="+danieid,null)

        while(query.moveToNext()) {
            var description=query.getString(1)
            arrayListRepos.add(getString(description.toInt()))
        }

        val adapter: ArrayAdapter<String> = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            arrayListRepos
        )
        val listView=findViewById<ListView>(R.id.skladnikiopis)
        listView.adapter = adapter
    }

    fun dodajDoUlubionych(view: View){
        val lista_dan = intent.getStringArrayExtra("danieid")
        Toast.makeText(applicationContext,"Przepis dodany do ulubionych", Toast.LENGTH_SHORT).show()
        var helper=DataBaseHelper(applicationContext)
        var db=helper.readableDatabase

        db?.execSQL("INSERT INTO ULUBIONE(NAZWAPRZEPISU, TYPPRZEPISU VALUES ('"+lista_dan?.get(1)+"', "+lista_dan?.get(2)+"')")
    }

    fun dodajDoOstatnich(view: View){
        val lista_dan = intent.getStringArrayExtra("danieid")
        Toast.makeText(applicationContext,"Przepis dodany do ostatnich", Toast.LENGTH_SHORT).show()
        var helper=DataBaseHelper(applicationContext)
        var db=helper.readableDatabase

        db?.execSQL("INSERT INTO OSTATNIE(NAZWAPRZEPISU, TYPPRZEPISU VALUES ('"+lista_dan?.get(1)+"', "+lista_dan?.get(2)+"')")
    }
}