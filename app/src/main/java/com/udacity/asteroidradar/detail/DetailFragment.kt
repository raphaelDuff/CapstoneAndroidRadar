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

        val binding = FragmentDetailBinding.inflate(inflater)
        val application = requireNotNull(activity).application

        // Safeargs to pass Android data between Fragments
        val asteroid = DetailFragmentArgs.fromBundle(requireArguments()).selectedAsteroid
        // ViewModel initialization with the asteroid collected by Safeargs
        val viewModelFactory = DetailViewModelFactory(asteroid,application)
        binding.lifecycleOwner = this
        binding.detailViewModel = ViewModelProvider(
            this, viewModelFactory).get(DetailViewModel::class.java
        )

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
