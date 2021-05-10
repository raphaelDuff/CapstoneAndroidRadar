package com.udacity.asteroidradar.main

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.udacity.asteroidradar.api.AsteroidsApi
import com.udacity.asteroidradar.api.ServiceAsteroid
import com.udacity.asteroidradar.api.parseAsteroidsJsonResult
import com.udacity.asteroidradar.database.Asteroid
import kotlinx.coroutines.launch
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

enum class AsteroidsApiStatus { LOADING, ERROR, DONE}

class MainViewModel : ViewModel() {

    // The internal MutableLiveData String that stores the status of the most recent request
    private val _status = MutableLiveData<AsteroidsApiStatus>()

    // The external immutable LiveData for the request status String
    val status: LiveData<AsteroidsApiStatus>
        get() = _status

    private val _navigateToAsteroidDetail = MutableLiveData<Asteroid>()
    val navigateToAsteroidDetail: LiveData<Asteroid>
        get() = _navigateToAsteroidDetail

    private val _asteroids = MutableLiveData<List<Asteroid>>()
    // The external Livedata for the request status String
    val asteroids: LiveData<List<Asteroid>>
        get() = _asteroids

    fun onAsteroidClicked(asteroid: Asteroid){
        _navigateToAsteroidDetail.value = asteroid
    }

    fun onAsteroidDetailNavigated() {
        _navigateToAsteroidDetail.value = null

    }

    init {
        getAsteroids()
    }

    private fun getAsteroids() {
        AsteroidsApi.retrofitService.getAsteroids().enqueue(object: Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                _asteroids.value = parseAsteroidsJsonResult(JSONObject(response.body()))
                _status.value = AsteroidsApiStatus.DONE
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                _status.value = AsteroidsApiStatus.ERROR
            }
        })
    }


}
