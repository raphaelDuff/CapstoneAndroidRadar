package com.udacity.asteroidradar.database

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Apod(
    var copyright: String,
    var date: String,
    var explanation: String,
    var url: String
)


