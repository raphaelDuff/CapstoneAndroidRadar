/*
package com.udacity.asteroidradar.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.udacity.asteroidradar.Constants.API_QUERY_DATE_FORMAT
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

*/
/**
 * A retrofit service to fetch a devbyte Asteroids list.
 *//*

interface ServiceAsteroid {
    @GET("devbytes.json")
    fun getPlaylist(): Deferred<NetworkVideoContainer>
}

*/
/**
 * Build the Moshi object that Retrofit will be using, making sure to add the Kotlin adapter for
 * full Kotlin compatibility.
 *//*

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

*/
/**
 * Main entry point for network access. Call like `Network.devbytes.getPlaylist()`
 *//*

object NetworkAsteroids {
    // Configure retrofit to parse JSON and use coroutines
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://devbytes.udacity.com/")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

    val devbytes = retrofit.create(DevbyteService::class.java)
}*/
