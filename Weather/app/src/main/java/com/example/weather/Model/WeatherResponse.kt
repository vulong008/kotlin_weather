package com.example.WeatherKotlin.Model

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("list")
    val weather: ArrayList<com.example.WeatherKotlin.Model.Weather>) {
}