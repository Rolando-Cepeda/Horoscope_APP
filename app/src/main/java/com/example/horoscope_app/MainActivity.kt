package com.example.horoscope_app

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    //Creamos una lista par referenciar los horóscopos
    val horoscopeList: List<Horoscope> = listOf(
        Horoscope("aries","Aries", 0),
        Horoscope("aries","Taurus",0),
        Horoscope("aries","Gemini",0),
        Horoscope("aries","Cancer", 0),
        Horoscope("aries","Leo",0),
        Horoscope("aries","Virgo",0),
        Horoscope("aries","Libra",0),
        Horoscope("aries","Scorpio",0),
        Horoscope("aries","Sagitarius",0),
        Horoscope("aries","Capricornio",0),
        Horoscope("aries","Aquarius",0),
        Horoscope("aries","Piscis",0),
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        for(horoscope in horoscopeList){
            Log.i("HOROSCOPE", horoscope.name)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}