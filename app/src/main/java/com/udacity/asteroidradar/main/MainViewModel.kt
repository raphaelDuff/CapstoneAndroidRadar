/*
package com.udacity.asteroidradar.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.asteroidradar.database.Asteroid

class MainViewModel : ViewModel() {



    private val asteroids = mutableListOf<Asteroid>(asteroidOne, asteroidTwo, asteroidThree)
    private val _asteroids = MutableLiveData<List<Asteroid>>(asteroidOne, asteroidTwo, asteroidThree)

    val asteroids: LiveData<List<Asteroid>>
        get() = _asteroids

    init {
        _asteroids.value = asteroids
        Log.INFO("ViewModelCreated")
    }



}
*/
