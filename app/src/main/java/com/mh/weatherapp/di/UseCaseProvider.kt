package com.mh.weatherapp.di

import com.mh.data.datasource.remote.api.Api
import com.mh.data.datasource.remote.api.WeatherDataSourceRemote
import com.mh.data.datasource.repository.WeatherRepositoryData
import com.mh.domain.repository.WeatherRepository
import com.mh.domain.use_cases.GetWeatherUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseProvider {

    @Provides
    @Singleton
    fun provideWeatherRepository(api: Api): WeatherRepository {
        val dataSourceRemote = WeatherDataSourceRemote(api)
        return WeatherRepositoryData(dataSourceRemote)
    }

    @Provides
    @Singleton
    fun provideWeatherUseCase(repository: WeatherRepository): GetWeatherUseCase {
        return GetWeatherUseCase(repository)
    }
}