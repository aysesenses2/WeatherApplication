package com.example.weatherapplication


data class WeatherModel(
    val day: String,
    val weather: String,
    val weatherImageResId: Int,
    val temp: String,
    val temp2: String,
    val hummiditiy: String?
)
