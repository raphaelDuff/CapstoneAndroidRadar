package com.udacity.asteroidradar.api

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.udacity.asteroidradar.database.Apod
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET



private const val BASE_URL_APOD = "https://api.nasa.gov/planetary/"
interface ServiceApod {
    @GET("apod?api_key=FjxsliBqOEgeW05t2PYg62F5h40rafNezSWBJTqR")
    fun getApod():
    // The Coroutine Call Adapter allows us to return a Deferred, a Job with a result
            Call<Apod>
}
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofitApod = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL_APOD)
    .build()

object ApodApi {
    val retrofitApodService : ServiceApod by lazy { retrofitApod.create(ServiceApod::class.java) }
}