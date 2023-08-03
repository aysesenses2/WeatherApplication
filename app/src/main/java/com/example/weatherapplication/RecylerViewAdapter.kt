package com.example.weatherapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecylerViewAdapter(private val itemList: List<WeatherModel>) :
    RecyclerView.Adapter<RecylerViewAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // You can add other views here that you need to bind
        val weather: TextView = itemView.findViewById(R.id.weather)
        val day: TextView = itemView.findViewById(R.id.day)
        var weatherImage: ImageView = itemView.findViewById(R.id.weatherImage)
        val temp: TextView = itemView.findViewById(R.id.temp)
        val temp2: TextView = itemView.findViewById(R.id.temp2)
        val hummiditiy: TextView = itemView.findViewById(R.id.hummiditiy)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_weather, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Bind other views and data here
        val currentItem = itemList[position]

        holder.weather.text = currentItem.weather
        holder.day.text = currentItem.day
        holder.weatherImage.setImageResource(currentItem.weatherImageResId)
        holder.temp.text = currentItem.temp
        holder.temp2.text = currentItem.temp2
        holder.hummiditiy.text = currentItem.hummiditiy
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}