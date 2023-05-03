package com.mh.domain.use_cases

import com.mh.domain.models.WeatherModel
import com.mh.domain.models.WeatherRequest
import com.mh.domain.repository.WeatherRepository

class GetWeatherUseCase(private val repository: WeatherRepository) {

    suspend operator fun invoke(request: WeatherRequest): WeatherModel? =
        repository.getWeatherFromApi(request)
}