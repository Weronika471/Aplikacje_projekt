package com.example.android_projekt_252876

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHelper(context: Context) : SQLiteOpenHelper(context,"PRZEPISYDB",null,1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE PRZEPISY(PRZEPISID INTEGER PRIMARY KEY AUTOINCREMENT, NAZWAPRZEPISU TEXT, TYPPRZEPISU TEXT)")

        db?.execSQL("INSERT INTO PRZEPISY(NAZWAPRZEPISU, TYPPRZEPISU) VALUES ("+R.string.nazwaPrzepisu1+","+R.string.typPrzepisu1+")")
        db?.execSQL("INSERT INTO PRZEPISY(NAZWAPRZEPISU, TYPPRZEPISU) VALUES ("+R.string.nazwaPrzepisu2+","+R.string.typPrzepisu1+")")
        db?.execSQL("INSERT INTO PRZEPISY(NAZWAPRZEPISU, TYPPRZEPISU) VALUES ("+R.string.nazwaPrzepisu3+","+R.string.typPrzepisu1+")")
        db?.execSQL("INSERT INTO PRZEPISY(NAZWAPRZEPISU, TYPPRZEPISU) VALUES ("+R.string.nazwaPrzepisu4+","+R.string.typPrzepisu2+")")
        db?.execSQL("INSERT INTO PRZEPISY(NAZWAPRZEPISU, TYPPRZEPISU) VALUES ("+R.string.nazwaPrzepisu5+","+R.string.typPrzepisu2+")")
        db?.execSQL("INSERT INTO PRZEPISY(NAZWAPRZEPISU, TYPPRZEPISU) VALUES ("+R.string.nazwaPrzepisu6+","+R.string.typPrzepisu2+")")
        db?.execSQL("INSERT INTO PRZEPISY(NAZWAPRZEPISU, TYPPRZEPISU) VALUES ("+R.string.nazwaPrzepisu7+","+R.string.typPrzepisu3+")")
        db?.execSQL("INSERT INTO PRZEPISY(NAZWAPRZEPISU, TYPPRZEPISU) VALUES ("+R.string.nazwaPrzepisu8+","+R.string.typPrzepisu3+")")
        db?.execSQL("INSERT INTO PRZEPISY(NAZWAPRZEPISU, TYPPRZEPISU) VALUES ("+R.string.nazwaPrzepisu9+","+R.string.typPrzepisu3+")")

        db?.execSQL("CREATE TABLE OPIS(OPISID INTEGER PRIMARY KEY AUTOINCREMENT,OPIS TEXT)")

        db?.execSQL("INSERT INTO OPIS(OPIS) VALUES ("+R.string.przepis1+")")
        db?.execSQL("INSERT INTO OPIS(OPIS) VALUES ("+R.string.przepis2+")")
        db?.execSQL("INSERT INTO OPIS(OPIS) VALUES ("+R.string.przepis3+")")
        db?.execSQL("INSERT INTO OPIS(OPIS) VALUES ("+R.string.przepis4+")")
        db?.execSQL("INSERT INTO OPIS(OPIS) VALUES ("+R.string.przepis5+")")
        db?.execSQL("INSERT INTO OPIS(OPIS) VALUES ("+R.string.przepis6+")")
        db?.execSQL("INSERT INTO OPIS(OPIS) VALUES ("+R.string.przepis7+")")
        db?.execSQL("INSERT INTO OPIS(OPIS) VALUES ("+R.string.przepis8+")")
        db?.execSQL("INSERT INTO OPIS(OPIS) VALUES ("+R.string.przepis9+")")

        db?.execSQL("CREATE TABLE ULUBIONE(PRZEPISID INTEGER PRIMARY KEY AUTOINCREMENT,NAZWAPRZEPISU TEXT, TYPPRZEPISU TEXT)")

        db?.execSQL("CREATE TABLE OSTATNIE(PRZEPISID INTEGER PRIMARY KEY AUTOINCREMENT,NAZWAPRZEPISU TEXT, TYPPRZEPISU TEXT)")

    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {

    }
}