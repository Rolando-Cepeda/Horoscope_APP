package com.example.horoscope_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HoroscopeAdapter(private val dataSet: List<Horoscope>) :
    RecyclerView.Adapter<HoroscopeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_horoscope, parent, false)
        return HoroscopeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
        val horoscope = dataSet[position]
        holder.render(horoscope)
    }
}

class HoroscopeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val nameTextView: TextView
    val descTextView: TextView
    val logoImageView: ImageView


    init {
        nameTextView = view.findViewById(R.id.nameTextView)
        descTextView = view.findViewById(R.id.descTextView)
        logoImageView = view.findViewById(R.id.logoImageView)
    }

    fun render(horoscope: Horoscope) {
        nameTextView.setText(horoscope.name)
        descTextView.setText(horoscope.description)
        logoImageView.setImageResource(horoscope.logo)
    }
}