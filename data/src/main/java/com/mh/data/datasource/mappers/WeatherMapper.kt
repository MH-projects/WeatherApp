package com.mh.data.datasource.mappers

import com.mh.data.datasource.remote.dto.WeatherResponse
import com.mh.domain.models.WeatherModel

fun WeatherResponse.toWeatherModel(): WeatherModel {
    return WeatherModel(
        temp = this.main.temp,
        weather = this.weather[0].main,
        temp_min = this.main.temp_min,
        temp_max = this.main.temp_max,
        name = this.name,
        country = this.sys.country,
        humidity = this.main.humidity,
        speed = this.wind.speed,
    )
}