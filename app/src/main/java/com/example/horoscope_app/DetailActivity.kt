package com.example.horoscope_app

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailActivity : AppCompatActivity() {
    // Definimos una constante, la misma que la podemos utilizar en el MainActivity
    companion object {
        const val EXTRA_HOROSCOPE_ID = "HOROSCOPE_ID"
    }

    lateinit var horoscope: Horoscope
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val id = intent.getStringExtra(EXTRA_HOROSCOPE_ID)

        horoscope = HoroscopeProvider.findById(id!!)!!

        //Mostramos el nombre y el logo.
        findViewById<TextView>(R.id.textView).setText(horoscope.name)
        findViewById<ImageView>(R.id.imageView).setImageResource(horoscope.logo)


    }
}