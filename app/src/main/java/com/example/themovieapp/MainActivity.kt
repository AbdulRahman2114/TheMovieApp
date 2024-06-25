package com.example.themovieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

import com.example.themovieapp.fragment.MovieFragment
import com.example.themovieapp.fragment.ProfileFragment
import com.example.themovieapp.fragment.TVFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val movieFragment = MovieFragment()
        val tvFragment = TVFragment()
        val proFrag = ProfileFragment()

        makeCurrentFragment (movieFragment)

        val bottomnavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomnavigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_movie -> makeCurrentFragment(movieFragment)
                R.id.menu_tv -> makeCurrentFragment(tvFragment)
                R.id.profile -> makeCurrentFragment(proFrag)
            }
            true
        }
    }

    private fun makeCurrentFragment(proFrag: ProfileFragment) {
        TODO("Not yet implemented")
    }

    fun makeCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fram_nav, fragment)
            commit()
        }

    }

}