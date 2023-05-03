package com.mh.weatherapp.weather

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mh.domain.models.WeatherRequest
import com.mh.domain.use_cases.GetWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherUseCase: GetWeatherUseCase
) : ViewModel() {

    private val _weatherStatus = MutableLiveData<WeatherStatus>()
    val weatherStatus: LiveData<WeatherStatus> get() = _weatherStatus

    fun getWeather(request: WeatherRequest) {
        viewModelScope.launch {
            _weatherStatus.postValue(WeatherStatus.LOADING)
            val result = weatherUseCase(request)

            if (result != null) {
                _weatherStatus.postValue(WeatherStatus.SUCCESS(result))
            } else {
                _weatherStatus.postValue(
                    WeatherStatus.FAILURE("Hubo un problema al obtener el clima, por favor intente más tarde.")
                )
            }
        }
    }
}