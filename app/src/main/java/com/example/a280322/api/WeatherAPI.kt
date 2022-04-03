package com.example.a280322.api

import com.example.a280322.model.WeatherData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {
    @GET("data/2.5/weather")
    fun getWeatherData(
        @Query("q")
        cityName: String,
        @Query("appid")
        appId: String
    ): Call<WeatherData>?
}