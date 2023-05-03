package com.mh.domain.repository

import com.mh.domain.models.WeatherModel
import com.mh.domain.models.WeatherRequest

interface WeatherRepository {
    suspend fun getWeatherFromApi(request: WeatherRequest): WeatherModel?
}