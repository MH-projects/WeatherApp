package com.mh.weatherapp.weather

import android.content.Context
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.mh.domain.models.WeatherRequest
import com.mh.weatherapp.databinding.ActivityWeatherBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class WeatherActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWeatherBinding
    private val viewModel: WeatherViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)


        Dexter.withContext(this)
            .withPermissions(
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION,
            ).withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(report: MultiplePermissionsReport) {
                    report.let {

                        if (report.areAllPermissionsGranted()) {
                            // TODO: CONFIGURE AND GET LOCATION FROM GPS
                        }
                    }
                }

                override fun onPermissionRationaleShouldBeShown(
                    permissions: List<PermissionRequest?>?,
                    token: PermissionToken?
                ) {
                }
            }).check()

        viewModel.getWeather(WeatherRequest(19.42847, -99.12766))

        viewModel.weatherStatus.observe(this) {
            when (it) {
                is WeatherStatus.LOADING -> binding.pbLoading.visibility = View.VISIBLE
                is WeatherStatus.SUCCESS -> {
                    binding.pbLoading.visibility = View.GONE
                    with(binding) {
                        tvWeatherValue.text = it.weather.weather
                        tvHumidityValue.text = it.weather.humidity.toString()
                        tvWindValue.text = it.weather.speed.toString()
                        tvMinimumTitle.text = it.weather.temp_min.toString()
                        tvMinimumValue.text = it.weather.temp_max.toString()
                        tvNameTitle.text = it.weather.name
                        tvNameValue.text = it.weather.country
                    }
                }
                is WeatherStatus.FAILURE -> {
                    Log.d("WEATHER", "FAILURE: ${it.message}")
                    binding.pbLoading.visibility = View.GONE
                }
            }
        }
    }

    private fun isLocationEnabled(): Boolean {

        // Esta function provee accesso a los servicios de ubicacion del sistema.
        val locationManager: LocationManager =
            getSystemService(Context.LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
            LocationManager.NETWORK_PROVIDER
        )
    }
}