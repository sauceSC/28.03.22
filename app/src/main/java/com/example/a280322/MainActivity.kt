package com.example.a280322
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.a280322.api.RetrofitClient
import com.example.a280322.api.WeatherAPI
import com.example.a280322.databinding.ActivityMainBinding
import com.example.a280322.model.WeatherData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val api: WeatherAPI = RetrofitClient.getRetrofit().create(WeatherAPI::class.java)

    private val binding:ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) = with(binding) {
        super.onCreate(savedInstanceState)
        setContentView(root)

        val key = getString(R.string.weather_api_key)

        api.getWeatherData("Bishkek", key).enqueue(object : Callback<WeatherData> {
            override fun onFailure(call: Call<WeatherData>, t: Throwable) {
                Log.e("$$$", "Something happened wrong")
                Log.i("$$$", t.cause.toString())
            }

            override fun onResponse(
                call: Call<WeatherData>,
                response: Response<WeatherData>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    val data = response.body()!!
                    Log.i("$$$", "Smthng in OnResponse")
                    var appId = data.id.toString()
                    var cityName = data.name.toString()
                    var temp = data.main.temp.toString()
                }
            }
        })
    }

}
