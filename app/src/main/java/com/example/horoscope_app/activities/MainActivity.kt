package com.example.horoscope_app.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscope_app.data.Horoscope
import com.example.horoscope_app.adapters.HoroscopeAdapter
import com.example.horoscope_app.data.HoroscopeProvider
import com.example.horoscope_app.R

class MainActivity : AppCompatActivity() {

    //Creamos una lista par referenciar los horóscopos

    // Creamos la variable para acceder al horoscopeList de la clase HoroscopeProvider
    lateinit var horoscopeList: List<Horoscope>

    lateinit var recyclerView: RecyclerView

    lateinit var adapter: HoroscopeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Como ya tenemos la variable horoscopeList, la inicializamos
        horoscopeList = HoroscopeProvider.findAll()

        recyclerView = findViewById(R.id.recyclerView)

        adapter = HoroscopeAdapter(horoscopeList) { position ->
            navigateToDetail(horoscopeList[position])
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        //recyclerView.layoutManager = GridLayoutManager(this, 2)

    }

    override fun onResume(){
        super.onResume()
        adapter.updateData(horoscopeList)
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_activity_main, menu)

        val searchViewItem = menu.findItem(R.id.menu_search)
        val searchView = searchViewItem.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    horoscopeList = HoroscopeProvider.findAll().filter {
                        getString(it.name).contains(newText, true) ||
                                getString(it.description).contains(newText, true)
                    }
                    adapter.updateData(horoscopeList, newText)
                }
                return true
            }
        })

        return true
    }

    // Esto nos llevará al la pantalla DEATIL a través del INTENT, en donde le pasaremos ésta clase y la
    // clase DetailActivity
    fun navigateToDetail(horoscope: Horoscope) {
        val intent: Intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_HOROSCOPE_ID, horoscope.id)
        startActivity(intent)
    }
}