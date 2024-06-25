package com.example.themovieapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.themovieapp.fragment.MovieFragment
import com.example.themovieapp.fragment.ProfileFragment
import com.example.themovieapp.fragment.TVFragment

class ViewPageAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> MovieFragment()
            1 -> TVFragment()
            2 -> ProfileFragment()
            else -> throw IllegalStateException("Unexpected position $position")
        }
    }
}
