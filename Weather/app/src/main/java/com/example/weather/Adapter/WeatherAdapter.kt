package com.example.WeatherKotlin.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.WeatherKotlin.Model.Weather

import com.example.weather.R
import java.text.SimpleDateFormat
import java.util.*

class WeatherAdapter(var weatherList: ArrayList<Weather>) :
    RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {
    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        lateinit var textTime: TextView
        lateinit var textTemp: TextView
        lateinit var textTempMax: TextView
        lateinit var textTempMin: TextView

        init {
            textTemp = item.findViewById(R.id.textTemp)
            textTime = item.findViewById(R.id.textTime)
            textTempMax = item.findViewById(R.id.textTempMax)
            textTempMin = item.findViewById(R.id.textTempMin)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var weather = weatherList.get(position)
        var date: Date = Date(weather.dt * 1000L)
        var sdf = SimpleDateFormat("yyyy-MM-dd");
        sdf.timeZone = TimeZone.getTimeZone("GMT+7")
        var timeString = sdf.format(date);
        holder.textTime.text = timeString;
        val temp: Double = weather.main.temp - 273
        val tempMax: Double = weather.main.temp_max - 273
        val tempMin: Double = weather.main.temp_min - 273
        val tempString = String.format("%.02f", temp)
        val tempMaxString = String.format("%.02f", tempMax)
        val tempMinString = String.format("%.02f", tempMin)
        holder.textTemp.text = tempString + 0x00B0.toChar() + " C"
        holder.textTempMax.text = tempMaxString + 0x00B0.toChar() + " C"
        holder.textTempMin.setText(tempMinString + 0x00B0.toChar() + " C")


    }

    override fun getItemCount(): Int {
        return weatherList.size
    }
}