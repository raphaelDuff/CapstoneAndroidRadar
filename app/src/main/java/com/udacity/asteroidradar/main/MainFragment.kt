package com.udacity.asteroidradar.main

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.udacity.asteroidradar.database.Asteroid
import com.udacity.asteroidradar.R
import com.udacity.asteroidradar.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private val mainViewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Get a reference to the binding object and inflate the fragment views.
        val binding: FragmentMainBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_main, container, false)


        binding.lifecycleOwner = this
        val mainViewModel = mainViewModel
        setHasOptionsMenu(true)

        // Create the adapter variable that is the Adapter constructed in the another file for the Recycler View
        val adapter = AsteroidListAdapter(AsteroidListAdapter.AsteroidListener {
            mainViewModel.onAsteroidClicked(it)
        })

        // Associates the Recycle View name in layout.xml
        binding.asteroidRecycler.adapter = adapter



       /* mainViewModel.navigateToAsteroidDetail.observe(viewLifecycleOwner, Observer {id ->
            id?.let {
                this.findNavController().navigate(MainFragmentDirections
                    .actionMainFragmentToDetailFragment(id))
                mainViewModel.onAsteroidDetailNavigated()
            }
        })*/

        mainViewModel.navigateToAsteroidDetail.observe(viewLifecycleOwner, Observer {
            if (null != it) {
                this.findNavController().navigate(MainFragmentDirections.actionMainFragmentToDetailFragment(it))
                mainViewModel.onAsteroidDetailNavigated()
            }
        })

        return binding.root

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_overflow_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return true
    }

}
