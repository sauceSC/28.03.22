package com.example.a280322

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a280322.api.RetrofitClient
import com.example.a280322.api.WeatherAPI
import com.example.a280322.databinding.ActivityMainBinding
import com.example.a280322.model.WeatherData
import retrofit2.Callback
import retrofit2.create

val api: WeatherAPI? = RetrofitClient.getRetrofit()?.create(WeatherAPI::class.java)

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?): Unit = with(binding)  {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


    }


}