package com.mh.data.datasource.remote.api

import com.mh.data.datasource.remote.dto.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET(PATH.GET_WEATHER)
    suspend fun getWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") api_key: String,
    ): Response<WeatherResponse>
}