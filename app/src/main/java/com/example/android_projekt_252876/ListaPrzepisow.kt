package com.example.android_projekt_252876

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.core.content.ContextCompat

class ListaPrzepisow : AppCompatActivity() {

    private val arrayListRepos = ArrayList<String>()
    val listaPrzepisow= ArrayList<PrzepisElementy>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_przepisow)

        val actionBar = supportActionBar
        actionBar!!.title = "Lista przepisów"
        window.statusBarColor = ContextCompat.getColor(this, R.color.teal_700)

        var helper=DataBaseHelper(applicationContext)
        var db=helper.readableDatabase
        val rodzajDania = intent.getStringExtra("danie")

        if(rodzajDania == "Przekaski") {

            var query=db.rawQuery("SELECT * FROM PRZEPISY WHERE TYPPRZEPISU LIKE "+R.string.typPrzepisu1,null)
            while(query.moveToNext()) {
                var nazwaPrzepisu=query.getString(1)
                arrayListRepos.add(getString(nazwaPrzepisu.toInt()))
            }
            listaPrzepisow.add(PrzepisElementy(R.drawable.chrupiacy_kalafior,"Chrupiący kalafior z piekarnika"))
            listaPrzepisow.add(PrzepisElementy(R.drawable.pasta_awoka_jajka,"Delikatna pasta z awokado i jajek"))
            listaPrzepisow.add(PrzepisElementy(R.drawable.pasta_jajeczna_ser,"Pasta jajeczna z żółtym serem"))

            val customAdapter = CustomAdapter(this,R.layout.custom_list,listaPrzepisow)
            val listView=findViewById<ListView>(R.id.lista)
            listView.adapter = customAdapter

            listView.setOnItemClickListener { parent, view, position, id ->
                val intent = Intent(this, Przepis::class.java)
                val przepis :PrzepisElementy = listaPrzepisow[position]
                intent.putExtra("danieid", arrayOf((position+1).toString(),przepis.Name,"Przekaski"))
                startActivity(intent)
            }

        }else if(rodzajDania == "Obiad"){

            var query=db.rawQuery("SELECT * FROM PRZEPISY WHERE TYPPRZEPISU LIKE "+R.string.typPrzepisu2,null)
            while(query.moveToNext()) {
                var plantName=query.getString(1)
                arrayListRepos.add(getString(plantName.toInt()))
            }
            listaPrzepisow.add(PrzepisElementy(R.drawable.curry_fasolka_hortex,"Kurczak curry z fasolką szparagową"))
            listaPrzepisow.add(PrzepisElementy(R.drawable.risotto_cukinia_rzymska,"Risotto z cukinią i sałatą rzymską"))
            listaPrzepisow.add(PrzepisElementy(R.drawable.zupa_golabkowa,"Zupa gołąbkowa"))

            val customAdapter = CustomAdapter(this,R.layout.custom_list,listaPrzepisow)
            val listView=findViewById<ListView>(R.id.lista)
            listView.adapter = customAdapter

            listView.setOnItemClickListener { parent, view, position, id ->
                val intent = Intent(this, Przepis::class.java)
                val przepis :PrzepisElementy = listaPrzepisow[position]
                intent.putExtra("danieid", arrayOf((position+4).toString(),przepis.Name,"Obiad"))
                startActivity(intent)
            }
        } else {

            var query=db.rawQuery("SELECT * FROM PRZEPISY WHERE TYPPRZEPISU LIKE "+R.string.typPrzepisu3,null)
            while(query.moveToNext()) {
                var plantName=query.getString(1)
                arrayListRepos.add(getString(plantName.toInt()))
            }
            listaPrzepisow.add(PrzepisElementy(R.drawable.ciasto_4jablka_4jajka,"Ciasto 4 jabłka i 4 jajka"))
            listaPrzepisow.add(PrzepisElementy(R.drawable.placki_jogurtowe_banany,"Placki jogurtowe z bananami"))
            listaPrzepisow.add(PrzepisElementy(R.drawable.racuchy_na_maslance1,"Racuchy na maślance z jabłkami"))

            val customAdapter = CustomAdapter(this,R.layout.custom_list,listaPrzepisow)
            val listView=findViewById<ListView>(R.id.lista)
            listView.adapter = customAdapter

            listView.setOnItemClickListener { parent, view, position, id ->
                val intent = Intent(this, Przepis::class.java)
                val przepis :PrzepisElementy = listaPrzepisow[position]
                intent.putExtra("danieid", arrayOf((position+7).toString(),przepis.Name,"Deser"))
                startActivity(intent)
            }

        }



    }
}