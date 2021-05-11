package com.udacity.asteroidradar.main

import android.app.Application
import android.util.Log

import androidx.lifecycle.*
import com.udacity.asteroidradar.api.ApodApi
import com.udacity.asteroidradar.database.Apod
import com.udacity.asteroidradar.database.Asteroid
import com.udacity.asteroidradar.database.getDatabase
import com.udacity.asteroidradar.repository.AsteroidsRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

enum class AsteroidApodsApiStatus { LOADING, ERROR, DONE}

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val viewModelJob = SupervisorJob()

    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val database = getDatabase(application)

    private val asteroidsRepository = AsteroidsRepository(database)

    // The internal MutableLiveData String that stores the status of the most recent request
    private val _status = MutableLiveData<AsteroidApodsApiStatus>()
    // The external immutable LiveData for the request status String
    val status: LiveData<AsteroidApodsApiStatus>
        get() = _status

    // The internal MutableLiveData String that stores the status of the most recent request
    private val _apodStatus = MutableLiveData<AsteroidApodsApiStatus>()
    // The external immutable LiveData for the request status String
    val apodStatus: LiveData<AsteroidApodsApiStatus>
        get() = _apodStatus

    // Trigger the Listener Button to navigate to Detail Screen
    private val _navigateToAsteroidDetail = MutableLiveData<Asteroid>()
    val navigateToAsteroidDetail: LiveData<Asteroid>
        get() = _navigateToAsteroidDetail

    /*// Mutable Asteroids lists that will receive API DATA
    private val _asteroids = MutableLiveData<List<Asteroid>>()
    // The external Livedata for the request status String
    val asteroids: LiveData<List<Asteroid>>
        get() = _asteroids*/

    // Image of the Day Variables
    private val _apod = MutableLiveData<Apod>()
    val apod: LiveData<Apod>
        get() = _apod

    fun onAsteroidClicked(asteroid: Asteroid){
        _navigateToAsteroidDetail.value = asteroid
    }

    fun onAsteroidDetailNavigated() {
        _navigateToAsteroidDetail.value = null

    }

    init {

        viewModelScope.launch {
            asteroidsRepository.refreshAsteroids()
        }

        // getAsteroids()
        getApod()
        Log.i("MERDA", "BOSTA")
    }

    val asteroids = asteroidsRepository.asteroids

//    private fun getAsteroids() {
//        AsteroidsApi.retrofitService.getAsteroids().enqueue(object: Callback<String> {
//            override fun onResponse(call: Call<String>, response: Response<String>) {
//                _asteroids.value = parseAsteroidsJsonResult(JSONObject(response.body()))
//                _status.value = AsteroidApodsApiStatus.DONE
//            }
//
//            override fun onFailure(call: Call<String>, t: Throwable) {
//                _status.value = AsteroidApodsApiStatus.ERROR
//            }
//        })
//    }

    private fun getApod() {
        ApodApi.retrofitApodService.getApod().enqueue(object: Callback<Apod> {
            override fun onResponse(call: Call<Apod>, response: Response<Apod>) {
                _apod.value = response.body()!!
                val tetona = response.body()!!
                val imgUrl = apod.value!!.url
                _status.value = AsteroidApodsApiStatus.DONE
            }

            override fun onFailure(call: Call<Apod>, t: Throwable) {
                _apodStatus.value = AsteroidApodsApiStatus.ERROR
            }
        })
    }




}
