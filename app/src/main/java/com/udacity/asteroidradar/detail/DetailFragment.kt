package com.udacity.asteroidradar.detail


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.udacity.asteroidradar.R
import com.udacity.asteroidradar.database.Asteroid
import com.udacity.asteroidradar.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        /*val asteroidOne = Asteroid(
            id = 5417625478,
            codename = "aaa",
            closeApproachDate = "2021-05-09",
            absoluteMagnitude = 1234.57,
            estimatedDiameter = 1234.57,
            relativeVelocity = 1234.57,
            distanceFromEarth = 1234.57,
            isPotentiallyHazardous = true
        )

        val asteroidTwo = Asteroid(
            id = 874458847,
            codename = "bbb",
            closeApproachDate = "2021-05-10",
            absoluteMagnitude = 1234.57,
            estimatedDiameter = 1234.57,
            relativeVelocity = 1234.57,
            distanceFromEarth = 1234.57,
            isPotentiallyHazardous = true
        )

        val asteroidThree = Asteroid(
            id = 658458441,
            codename = "ccc",
            closeApproachDate = "2021-05-11",
            absoluteMagnitude = 1234.57,
            estimatedDiameter = 1234.57,
            relativeVelocity = 1234.57,
            distanceFromEarth = 1234.57,
            isPotentiallyHazardous = false
        )

        val asteroidFour = Asteroid(
            id = 658458446,
            codename = "ddd",
            closeApproachDate = "2021-05-16",
            absoluteMagnitude = 1234.57,
            estimatedDiameter = 1234.57,
            relativeVelocity = 1234.57,
            distanceFromEarth = 1234.57,
            isPotentiallyHazardous = false
        )

        val asteroidFive = Asteroid(
            id = 6584584534,
            codename = "eee",
            closeApproachDate = "2021-05-15",
            absoluteMagnitude = 1234.57,
            estimatedDiameter = 1234.57,
            relativeVelocity = 1234.57,
            distanceFromEarth = 1234.57,
            isPotentiallyHazardous = true
        )

        val asteroidSix = Asteroid(
            id = 6584584222,
            codename = "fff",
            closeApproachDate = "2021-05-14",
            absoluteMagnitude = 1234.57,
            estimatedDiameter = 1234.57,
            relativeVelocity = 1234.57,
            distanceFromEarth = 1234.57,
            isPotentiallyHazardous = true
        )

        val asteroidSeven = Asteroid(
            id = 6584581111,
            codename = "ggg",
            closeApproachDate = "2021-05-13",
            absoluteMagnitude = 1234.57,
            estimatedDiameter = 1234.57,
            relativeVelocity = 1234.57,
            distanceFromEarth = 1234.57,
            isPotentiallyHazardous = false
        )

        val asteroidEight = Asteroid(
            id = 658450000,
            codename = "hhh",
            closeApproachDate = "2021-05-12",
            absoluteMagnitude = 1234.57,
            estimatedDiameter = 1234.57,
            relativeVelocity = 1234.57,
            distanceFromEarth = 1234.57,
            isPotentiallyHazardous = true
        )

        var asteroids = listOf<Asteroid>(asteroidOne, asteroidTwo, asteroidThree, asteroidFour,
            asteroidFive, asteroidSix, asteroidSeven, asteroidEight)*/

        val binding = FragmentDetailBinding.inflate(inflater)
        val application = requireNotNull(activity).application

        val asteroid = DetailFragmentArgs.fromBundle(requireArguments()).selectedAsteroid
        val viewModelFactory = DetailViewModelFactory(asteroid,application)
        binding.lifecycleOwner = this
        binding.viewModel = ViewModelProvider(
            this, viewModelFactory).get(DetailViewModel::class.java
        )

        // var asteroidId = DetailFragmentArgs.fromBundle(requireArguments()).selectedAsteroidKey
        //var asteroid: Asteroid = asteroids.filter { it.id == asteroidId }.single()


        binding.helpButton.setOnClickListener {
            displayAstronomicalUnitExplanationDialog()
        }

        return binding.root
    }

    private fun displayAstronomicalUnitExplanationDialog() {
        val builder = AlertDialog.Builder(requireActivity())
            .setMessage(getString(R.string.astronomica_unit_explanation))
            .setPositiveButton(android.R.string.ok, null)
        builder.create().show()
    }
}
