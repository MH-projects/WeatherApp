package com.mh.domain.models

data class WeatherModel(
    val temp: Double,
    val weather: String,
    val temp_min: Double,
    val temp_max: Double,
    val name: String,
    val country: String,
    val humidity: Int,
    val speed: Double,
)