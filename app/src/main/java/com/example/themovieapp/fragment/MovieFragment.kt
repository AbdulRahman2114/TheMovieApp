package com.example.themovieapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.themovieapp.MovieAdapter
import com.example.themovieapp.R

import com.example.themovieapp.model.Movie
import com.example.themovieapp.model.MovieResponse
import com.example.themovieapp.service.MovieApiInterface
import com.example.themovieapp.service.MovieApiService
import kotlinx.android.synthetic.main.fragment_movie.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private val movies = arrayListOf<Movie>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_movie.layoutManager = LinearLayoutManager(this.context)
        rv_movie.setHasFixedSize(true)
        getMovieData{movies: List<Movie> ->
            rv_movie.adapter = MovieAdapter(movies)
        }
        showRecycleView()
    }

    private fun getMovieData(callback: (List<Movie>) -> Unit) {
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieList().enqueue(object: Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t:Throwable){
            }
            override fun onResponse(call: Call<MovieResponse>,response: Response<MovieResponse>){
                return callback(response.body()!!.movies)
            }
        })
    }

    private fun showRecycleView(){
        rv_movie.layoutManager = LinearLayoutManager(this.context)
        rv_movie.adapter = MovieAdapter(movies)
    }
}