package com.example.WeatherKotlin.Presenter

import com.example.WeatherKotlin.Model.WeatherResponse

interface ForecastWeatherContract {
    interface View {
        fun getSuccess(weatherResponse: WeatherResponse)
        fun getFailure(err: String)
    }
    interface Presenter {
        fun getForecastWeather(lat: String, lon: String, appid: String)
    }
}