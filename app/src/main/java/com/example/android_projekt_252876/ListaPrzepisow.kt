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
        Toast.makeText(applicationContext, rodzajDania, Toast.LENGTH_SHORT).show()

        if(rodzajDania == "Przekaski") {

            var query=db.rawQuery("SELECT * FROM PRZEPISY WHERE TYPPRZEPISU LIKE "+R.string.typPrzepisu1,null)
            while(query.moveToNext()) {
                var nazwaPrzepisu=query.getString(1)
                arrayListRepos.add(getString(nazwaPrzepisu.toInt()))
            }
            listaPrzepisow.add(PrzepisElementy(R.drawable.zegar,"przekaska1"))
            listaPrzepisow.add(PrzepisElementy(R.drawable.zegar,"przekaska2"))
            listaPrzepisow.add(PrzepisElementy(R.drawable.zegar,"przekaska3"))

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
            listaPrzepisow.add(PrzepisElementy(R.drawable.zegar,"obiad1"))
            listaPrzepisow.add(PrzepisElementy(R.drawable.zegar,"obiad2"))
            listaPrzepisow.add(PrzepisElementy(R.drawable.zegar,"obiad3"))

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
            listaPrzepisow.add(PrzepisElementy(R.drawable.zegar,"deser1"))
            listaPrzepisow.add(PrzepisElementy(R.drawable.zegar,"deser2"))
            listaPrzepisow.add(PrzepisElementy(R.drawable.zegar,"deser3"))

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