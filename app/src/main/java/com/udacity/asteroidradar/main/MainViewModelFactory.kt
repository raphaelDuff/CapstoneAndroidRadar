//package com.udacity.asteroidradar.main
//
//import androidx.lifecycle.ViewModel
//import com.udacity.asteroidradar.database.Asteroid
//
//class MainViewModelFactory {
//
//    private val asteroidOne = Asteroid(
//        id = 5417625478,
//        codename = "aaa",
//        closeApproachDate = "2021-05-09",
//        absoluteMagnitude = 1234.57,
//        estimatedDiameter = 1234.57,
//        relativeVelocity = 1234.57,
//        distanceFromEarth = 1234.57,
//        isPotentiallyHazardous = true
//    )
//
//    private val asteroidTwo = Asteroid(
//        id = 874458847,
//        codename = "bbb",
//        closeApproachDate = "2021-05-10",
//        absoluteMagnitude = 1234.57,
//        estimatedDiameter = 1234.57,
//        relativeVelocity = 1234.57,
//        distanceFromEarth = 1234.57,
//        isPotentiallyHazardous = true
//    )
//
//    private val asteroidThree = Asteroid(
//        id = 658458441,
//        codename = "ccc",
//        closeApproachDate = "2021-05-11",
//        absoluteMagnitude = 1234.57,
//        estimatedDiameter = 1234.57,
//        relativeVelocity = 1234.57,
//        distanceFromEarth = 1234.57,
//        isPotentiallyHazardous = false
//    )
//
//    private val asteroidFour = Asteroid(
//        id = 658458441,
//        codename = "ddd",
//        closeApproachDate = "2021-05-16",
//        absoluteMagnitude = 1234.57,
//        estimatedDiameter = 1234.57,
//        relativeVelocity = 1234.57,
//        distanceFromEarth = 1234.57,
//        isPotentiallyHazardous = false
//    )
//
//    private val asteroidFive = Asteroid(
//        id = 658458441,
//        codename = "eee",
//        closeApproachDate = "2021-05-15",
//        absoluteMagnitude = 1234.57,
//        estimatedDiameter = 1234.57,
//        relativeVelocity = 1234.57,
//        distanceFromEarth = 1234.57,
//        isPotentiallyHazardous = true
//    )
//
//    private val asteroidSix = Asteroid(
//        id = 658458441,
//        codename = "fff",
//        closeApproachDate = "2021-05-14",
//        absoluteMagnitude = 1234.57,
//        estimatedDiameter = 1234.57,
//        relativeVelocity = 1234.57,
//        distanceFromEarth = 1234.57,
//        isPotentiallyHazardous = true
//    )
//
//    private val asteroidSeven = Asteroid(
//        id = 658458441,
//        codename = "ggg",
//        closeApproachDate = "2021-05-13",
//        absoluteMagnitude = 1234.57,
//        estimatedDiameter = 1234.57,
//        relativeVelocity = 1234.57,
//        distanceFromEarth = 1234.57,
//        isPotentiallyHazardous = false
//    )
//
//    private val asteroidEight = Asteroid(
//        id = 658458441,
//        codename = "hhh",
//        closeApproachDate = "2021-05-12",
//        absoluteMagnitude = 1234.57,
//        estimatedDiameter = 1234.57,
//        relativeVelocity = 1234.57,
//        distanceFromEarth = 1234.57,
//        isPotentiallyHazardous = true
//    )
//    var data = listOf<Asteroid>(asteroidOne, asteroidTwo, asteroidThree, asteroidFour,
//        asteroidFive, asteroidSix, asteroidSeven, asteroidEight)
//    private val sleepNightKey: Long,
//    private val dataSource: ) : ViewModelProvider.Factory {
//        @Suppress("unchecked_cast")
//        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//            if (modelClass.isAssignableFrom(SleepDetailViewModel::class.java)) {
//                return SleepDetailViewModel(sleepNightKey, dataSource) as T
//            }
//            throw IllegalArgumentException("Unknown ViewModel class")
//        }
//}