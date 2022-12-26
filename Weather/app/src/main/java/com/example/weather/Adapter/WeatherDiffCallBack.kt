package com.example.weather.Adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.WeatherKotlin.Model.Weather

class WeatherDiffCallBack : DiffUtil.ItemCallback<Weather>() {
    override fun areItemsTheSame(oldItem: Weather, newItem: Weather): Boolean {
        return oldItem.dt == newItem.dt
    }

    override fun areContentsTheSame(oldItem: Weather, newItem: Weather): Boolean {
        return oldItem == newItem
    }
}