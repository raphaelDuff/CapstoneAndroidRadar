package com.udacity.asteroidradar.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.udacity.asteroidradar.R
import com.udacity.asteroidradar.database.Asteroid
import com.udacity.asteroidradar.databinding.ListItemAsteroidBinding

class AsteroidListAdapter: RecyclerView.Adapter<AsteroidListAdapter.ViewHolder>() {
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

    private val asteroidFour = Asteroid(
        id = 658458441,
        codename = "ddd",
        closeApproachDate = "2021-05-16",
        absoluteMagnitude = 1234.57,
        estimatedDiameter = 1234.57,
        relativeVelocity = 1234.57,
        distanceFromEarth = 1234.57,
        isPotentiallyHazardous = false
    )

    private val asteroidFive = Asteroid(
        id = 658458441,
        codename = "eee",
        closeApproachDate = "2021-05-15",
        absoluteMagnitude = 1234.57,
        estimatedDiameter = 1234.57,
        relativeVelocity = 1234.57,
        distanceFromEarth = 1234.57,
        isPotentiallyHazardous = true
    )

    private val asteroidSix = Asteroid(
        id = 658458441,
        codename = "fff",
        closeApproachDate = "2021-05-14",
        absoluteMagnitude = 1234.57,
        estimatedDiameter = 1234.57,
        relativeVelocity = 1234.57,
        distanceFromEarth = 1234.57,
        isPotentiallyHazardous = true
    )

    private val asteroidSeven = Asteroid(
        id = 658458441,
        codename = "ggg",
        closeApproachDate = "2021-05-13",
        absoluteMagnitude = 1234.57,
        estimatedDiameter = 1234.57,
        relativeVelocity = 1234.57,
        distanceFromEarth = 1234.57,
        isPotentiallyHazardous = false
    )

    private val asteroidEight = Asteroid(
        id = 658458441,
        codename = "hhh",
        closeApproachDate = "2021-05-12",
        absoluteMagnitude = 1234.57,
        estimatedDiameter = 1234.57,
        relativeVelocity = 1234.57,
        distanceFromEarth = 1234.57,
        isPotentiallyHazardous = true
    )

    var data = listOf<Asteroid>(asteroidOne, asteroidTwo, asteroidThree, asteroidFour,
                                asteroidFive, asteroidSix, asteroidSeven, asteroidEight)
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        val res = holder.itemView.context.resources
        holder.codename.text = item.codename
        holder.approachDate.text = item.closeApproachDate

        holder.risk.setImageResource(when (item.isPotentiallyHazardous) {
            true -> R.drawable.ic_status_potentially_hazardous
            else -> R.drawable.ic_status_normal
        })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_asteroid, parent,false)
        return ViewHolder(view)
    }

    class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {

        val codename: TextView = itemView.findViewById(R.id.asteroid_name_string)
        val approachDate: TextView = itemView.findViewById(R.id.asteroid_date_string)
        val risk: ImageView = itemView.findViewById(R.id.asteroid_risk_imageic)

        /*fun bind(item: Asteroid) {
            val res = itemView.context.resources
            codename.text = item.codename
            approachDate.text = item.closeApproachDate
            risk.setImageResource(when (item.isPotentiallyHazardous) {
                true -> R.drawable.ic_status_potentially_hazardous
                else -> R.drawable.ic_status_normal
            })
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.list_item_asteroid, parent, false)
                return ViewHolder(view)
            }
        }*/
    }

    override fun getItemCount() = data.size

    class AsteroidDiffCallBack : DiffUtil.ItemCallback<Asteroid>() {
        override fun areItemsTheSame(oldItem: Asteroid, newItem: Asteroid): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Asteroid, newItem: Asteroid): Boolean {
            return oldItem == newItem
        }

    }

    class AsteroidListener(val clickListener: (id: Long) -> Unit) {
        fun onClick(asteroid: Asteroid) = clickListener(asteroid.id)
    }

}