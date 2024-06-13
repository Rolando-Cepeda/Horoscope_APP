package com.example.horoscope_app

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate

class MainActivity : AppCompatActivity() {

    //Creamos una lista par referenciar los horóscopos

    // Creamos la variable para acceder al horoscopeList de la clase HoroscopeProvider
    lateinit var horoscopeList: List<Horoscope>

    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Como ya tenemos la variable horoscopeList, la inicializamos
        horoscopeList = HoroscopeProvider.findAll()

        recyclerView = findViewById(R.id.recyclerView)

        val adapter = HoroscopeAdapter(horoscopeList) { position ->
            navigateToDetail(horoscopeList[position])
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        //recyclerView.layoutManager = GridLayoutManager(this, 2)

    }
    // Esto nos llevará al la pantalla DEATIL a través del INTENT, en donde le pasaremos ésta clase y la
    // clase DetailActivity
    fun navigateToDetail(horoscope: Horoscope) {
        val intent: Intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_HOROSCOPE_ID, horoscope.id)
        startActivity(intent)
    }
}