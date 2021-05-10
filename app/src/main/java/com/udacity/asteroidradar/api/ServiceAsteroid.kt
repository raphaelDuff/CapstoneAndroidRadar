package com.udacity.asteroidradar.api


import org.json.JSONObject
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


private const val BASE_URL = "https://api.nasa.gov/neo/rest/v1/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface ServiceAsteroid {
    @GET("feed?start_date=2021-05-10&api_key=FjxsliBqOEgeW05t2PYg62F5h40rafNezSWBJTqR")
    fun getAsteroids():
            Call<String>
}

object AsteroidsApi {
    val retrofitService : ServiceAsteroid by lazy {
        retrofit.create(ServiceAsteroid::class.java)
    }
}