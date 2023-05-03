# WeatherApp

## Arquitectura: MVVM + CLEAN ARCHITECTURE

Se implementó una arquitectura MVVM + Clean.

## Model
Se crea un caso de uso para obtener el clima

Se crea una interfaz de repositorio para que se consuma en la capa de data

Se crea un modelo con los datos necesarios para la UI

## Data
Se crea la implementación del uso de caso 

Se crea la petición a la api con Retrofit y MoshiConverter (Se decidió usar Moshi por qué esta más optimizado para Kotlin)

Se crean los DTO response y los mappers

## APP
Se crea la actividad principal

Se crea el ViewModel de su actividad

Se crea el binding para el binding de las vistas

Se crea la inyección de dependencias con Dagger Hilt

### TODO

Obtener las coordenadas del GPS ya que se tiene que configurar el LocationManager para establecer la exactitud, concurrencia, etc.


![Screenshot_20230503_140704](https://user-images.githubusercontent.com/19498432/236018845-7defd5cb-291c-4e3c-9514-607bcfe00d1d.png)
