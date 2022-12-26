package com.example.WeatherKotlin.Presenter

import com.example.WeatherKotlin.Model.WeatherResponse
import com.example.WeatherKotlin.RetrofitApi.RetrofitClient
import com.example.WeatherKotlin.RetrofitApi.WeatherService
import com.example.weather.Presenter.ForecastWeatherContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForecastWeatherPresent : ForecastWeatherContract.Presenter {
    private lateinit var view: ForecastWeatherContract.View
    fun attachView(view: ForecastWeatherContract.View) {
        this.view = view
    }

    override fun getForecastWeather(lat: String, lon: String, appid: String) {
        val weatherService: WeatherService? =
            RetrofitClient.getIntance?.create(WeatherService::class.java)
        weatherService?.let { service ->
            service.forecastWeather(lat, lon, appid)
                .enqueue(
                    object : Callback<WeatherResponse> {
                        override fun onResponse(
                            call: Call<WeatherResponse>,
                            response: Response<WeatherResponse>
                        ) {
                            response.body()?.let {
                                view.getSuccess(weatherResponse = it)
                            }
                        }

                        override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                            t.message?.let {
                                view.getFailure(it)
                            }
                        }
                    }
                )
        }
    }
}
