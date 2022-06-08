package com.example.android_projekt_252876

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class Przepis : AppCompatActivity() {

    private val arrayListRepos = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_przepis)

        supportActionBar?.hide()
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)

        val danieImage= arrayOf(R.drawable.chrupiacy_kalafior,R.drawable.pasta_awoka_jajka,R.drawable.pasta_jajeczna_ser,R.drawable.curry_fasolka_hortex,R.drawable.risotto_cukinia_rzymska,R.drawable.zupa_golabkowa,
            R.drawable.ciasto_4jablka_4jajka,R.drawable.placki_jogurtowe_banany,R.drawable.racuchy_na_maslance1)

        val image=findViewById<ImageView>(R.id.danieimage)
        val nameDesc=findViewById<Button>(R.id.nazwadania)
        val lista_dan = intent.getStringArrayExtra("danieid")
        val danieid= lista_dan?.get(0)
        val img=danieid?.toInt()
        val name=lista_dan?.get(1)
        nameDesc.text = name
        if (img != null) {
            image.setImageResource(danieImage[img-1])
        }

        val helper=DataBaseHelper(applicationContext)
        val db=helper.readableDatabase
        val query=db.rawQuery("SELECT * FROM OPIS WHERE OPISID ="+danieid,null)

        while(query.moveToNext()) {
            val description=query.getString(1)
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
        val helper=DataBaseHelper(applicationContext)
        val db=helper.readableDatabase

        db?.execSQL("INSERT INTO ULUBIONE(NAZWAPRZEPISU, TYPPRZEPISU) VALUES ('"+lista_dan?.get(1)+"','"+lista_dan?.get(2)+"')")
        Toast.makeText(applicationContext,"Przepis dodany do ulubionych", Toast.LENGTH_SHORT).show()
        val intent = Intent(this,UlubionePrzepisy::class.java)
        startActivity(intent)
    }

    fun dodajDoOstatnich(view: View){
        val lista_dan = intent.getStringArrayExtra("danieid")
        val helper=DataBaseHelper(applicationContext)
        val db=helper.readableDatabase

        db?.execSQL("INSERT INTO OSTATNIE(NAZWAPRZEPISU, TYPPRZEPISU) VALUES ('"+lista_dan?.get(1)+"','"+lista_dan?.get(2)+"')")
        Toast.makeText(applicationContext,"Przepis dodany do ostatnich", Toast.LENGTH_SHORT).show()
        val intent = Intent(this,OstatniePrzepisy::class.java)
        startActivity(intent)
    }
}