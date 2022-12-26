package com.example.WeatherKotlin.Model

import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("dt") var dt: Int,
    @SerializedName("main") var main: Main) {}