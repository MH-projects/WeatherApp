package com.mh.weatherapp.weather

import com.mh.domain.models.WeatherModel

sealed class WeatherStatus {

    object LOADING : WeatherStatus()

    data class SUCCESS(val weather: WeatherModel) : WeatherStatus()

    data class FAILURE(val message: String) : WeatherStatus()
}