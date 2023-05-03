package com.mh.data.datasource.remote.api

import com.mh.data.datasource.mappers.toWeatherModel
import com.mh.domain.models.WeatherRequest
import com.mh.domain.models.WeatherModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WeatherDataSourceRemote(private val api: Api) {

    suspend fun getWeather(request: WeatherRequest): WeatherModel {

        return withContext(Dispatchers.IO) {
            val response = api.getWeather(
                request.lat,
                request.lon,
                "f9d937f1dc49937d375ef14ffb36e76a"
            )
            response.body()!!.toWeatherModel()
        }
    }
}