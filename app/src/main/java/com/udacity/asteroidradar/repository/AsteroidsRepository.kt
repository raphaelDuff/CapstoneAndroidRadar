package com.udacity.asteroidradar.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.udacity.asteroidradar.api.AsteroidsApi.asteroidsget
import com.udacity.asteroidradar.api.parseAsteroidsJsonResult
import com.udacity.asteroidradar.database.Asteroid
import com.udacity.asteroidradar.database.AsteroidsDatabase
import com.udacity.asteroidradar.database.asDomainModel
import com.udacity.asteroidradar.network.NetworkAsteroid
import com.udacity.asteroidradar.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import retrofit2.await

class AsteroidsRepository(private val database: AsteroidsDatabase) {
    /*
    * A playlist of asteroids that can be show on the screen
    */
    val asteroids: LiveData<List<Asteroid>> = Transformations.map(database.asteroidDao.getAsteroidsDao()) {
        it.asDomainModel()
    }

    suspend fun refreshAsteroids() {
        withContext(Dispatchers.IO) {
            val asteroidListInterim = asteroidsget.getAsteroids().await()
            val asteroidList = parseAsteroidsJsonResult(JSONObject(asteroidListInterim))
            val networkAsteroidList = asteroidList.map {
                NetworkAsteroid(
                    it.id,
                    it.codename,
                    it.closeApproachDate,
                    it.absoluteMagnitude,
                    it.estimatedDiameter,
                    it.relativeVelocity,
                    it.distanceFromEarth,
                    it.isPotentiallyHazardous
                )
            }
            database.asteroidDao.insertAll(*networkAsteroidList.asDatabaseModel().toTypedArray())
        }
    }
}