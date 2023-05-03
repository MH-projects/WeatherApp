package com.mh.data.datasource.remote.dto

import com.squareup.moshi.Json

data class WeatherResponse(

    @field: Json(name = "coord")
    val coord: Coord,

    @field: Json(name = "weather")
    val weather: List<WeatherData>,

    @field: Json(name = "base")
    val base: String,

    @field: Json(name = "main")
    val main: MainData,

    @field: Json(name = "visibility")
    val visibility: Int,

    @field: Json(name = "wind")
    val wind: WindData,

    @field: Json(name = "clouds")
    val clouds: Clouds,

    @field: Json(name = "dt")
    val dt: Long,

    @field: Json(name = "sys")
    val sys: Sys,

    @field: Json(name = "id")
    val id: Int,

    @field: Json(name = "name")
    val name: String,

    @field: Json(name = "cod")
    val cod: Int
)

data class Coord(

    @field: Json(name = "lat")
    val lat: Double,

    @field: Json(name = "lon")
    val lon: Double
)

data class WeatherData(
    @field: Json(name = "id")
    val id: Int,

    @field: Json(name = "main")
    val main: String,

    @field: Json(name = "description")
    val description: String,

    @field: Json(name = "icon")
    val icon: String,
)

data class MainData(
    @field: Json(name = "temp")
    val temp: Double,

    @field: Json(name = "feels_like")
    val feels_like: Double,

    @field: Json(name = "temp_min")
    val temp_min: Double,

    @field: Json(name = "temp_max")
    val temp_max: Double,

    @field: Json(name = "pressure")
    val pressure: Int,

    @field: Json(name = "humidity")
    val humidity: Int,

    @field: Json(name = "sea_level")
    val sea_level: Int,

    @field: Json(name = "grnd_level")
    val grnd_level: Int,
)

data class WindData(
    @field: Json(name = "speed")
    val speed: Double,

    @field: Json(name = "deg")
    val deg: Int,

    @field: Json(name = "gust")
    val gust: Double,
)

data class Clouds(
    @field: Json(name = "all")
    val all: Int
)

data class Sys(
    @field: Json(name = "type")
    val type: Int,

    @field: Json(name = "id")
    val id: Int,

    @field: Json(name = "country")
    val country: String,

    @field: Json(name = "sunrise")
    val sunrise: Long,

    @field: Json(name = "sunset")
    val sunset: String,
)