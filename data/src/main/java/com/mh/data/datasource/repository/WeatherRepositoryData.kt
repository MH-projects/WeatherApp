package com.mh.data.datasource.repository

import com.mh.data.datasource.remote.api.WeatherDataSourceRemote
import com.mh.domain.models.WeatherRequest
import com.mh.domain.models.WeatherModel
import com.mh.domain.repository.WeatherRepository

class WeatherRepositoryData(
    private val weatherDataSourceRemote: WeatherDataSourceRemote,
) : WeatherRepository {

    override suspend fun getWeatherFromApi(request: WeatherRequest): WeatherModel? {

        return try {
            weatherDataSourceRemote.getWeather(request)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}