package com.example.WeatherKotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.WeatherKotlin.Adapter.WeatherAdapter
import com.example.WeatherKotlin.Model.Weather
import com.example.WeatherKotlin.Model.WeatherResponse
import com.example.WeatherKotlin.Presenter.ForecastWeatherPresent
import com.example.weather.Presenter.ForecastWeatherContract
import com.example.weather.R

class MainActivity : AppCompatActivity(), ForecastWeatherContract.View {
    private val presenter = ForecastWeatherPresent()
    private var weatherAdapter: WeatherAdapter? = null
    private val listWeather: ArrayList<Weather> = ArrayList()

    lateinit var recyclerview: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.attachView(this)
        recyclerview = findViewById(R.id.recyclerview)
        recyclerview.setHasFixedSize(true)
        presenter.getForecastWeather(LATITUDE, LONGTITUDE, APP_ID)
    }

    override fun getSuccess(weatherResponse: WeatherResponse) {
        weatherAdapter = WeatherAdapter(weatherResponse.weather)
        recyclerview.adapter = weatherAdapter
    }

    override fun getFailure(err: String) {
    }

    companion object {
        const val LATITUDE = "21"
        const val LONGTITUDE = "105"
        const val APP_ID = "2b0f1c2e6a3deab6d7f78949d22deb33"
    }
}
