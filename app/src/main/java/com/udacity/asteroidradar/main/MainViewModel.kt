/*
package com.udacity.asteroidradar.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.asteroidradar.database.Asteroid

class MainViewModel : ViewModel() {

     private val asteroidOne = Asteroid(
        id = 5417625478,
        codename = "aaa",
        closeApproachDate = "2021-05-09",
        absoluteMagnitude = 1234.57,
        estimatedDiameter = 1234.57,
        relativeVelocity = 1234.57,
        distanceFromEarth = 1234.57,
        isPotentiallyHazardous = true
    )

    private val asteroidTwo = Asteroid(
        id = 874458847,
        codename = "bbb",
        closeApproachDate = "2021-05-10",
        absoluteMagnitude = 1234.57,
        estimatedDiameter = 1234.57,
        relativeVelocity = 1234.57,
        distanceFromEarth = 1234.57,
        isPotentiallyHazardous = true
    )

    private val asteroidThree = Asteroid(
        id = 658458441,
        codename = "ccc",
        closeApproachDate = "2021-05-11",
        absoluteMagnitude = 1234.57,
        estimatedDiameter = 1234.57,
        relativeVelocity = 1234.57,
        distanceFromEarth = 1234.57,
        isPotentiallyHazardous = false
    )

    private val asteroids = mutableListOf<Asteroid>(asteroidOne, asteroidTwo, asteroidThree)
    private val _asteroids = MutableLiveData<List<Asteroid>>(asteroidOne, asteroidTwo, asteroidThree)

    val asteroids: LiveData<List<Asteroid>>
        get() = _asteroids

    init {
        _asteroids.value = asteroids
        Log.INFO("ViewModelCreated")
    }



}*/
