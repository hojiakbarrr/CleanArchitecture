package com.example.cleanarchitecture.presentation.screen_details

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.core.base.BaseFragment
import com.example.cleanarchitecture.databinding.HomeFragmentBinding
import com.example.cleanarchitecture.databinding.MovieDetailsFragmentBinding
import com.example.cleanarchitecture.presentation.model.Movie
import com.example.cleanarchitecture.presentation.screen_home.HomeViewModel
import com.example.cleanarchitecture.utils.showToast
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class MovieDetailsFragment : BaseFragment<MovieDetailsFragmentBinding, MovieDetailsViewModel>(MovieDetailsFragmentBinding::inflate) {
    override val viewModel: MovieDetailsViewModel by viewModels()

    private val movie:Movie by lazy(LazyThreadSafetyMode.NONE) {
        MovieDetailsFragmentArgs.fromBundle(requireArguments()).movie
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showToast(message = movie.title)
        preParMovie()
    }

    private fun preParMovie() {
        binding().apply {
            moviesDetailsTitle.text = movie.title
            Picasso.get()
                .load("https://image.tmdb.org/t/p/w500" + movie.poster_path)
                .into(moviesDetailsImageBanner)

            moviesDetailsDate.text = movie.release_date
            moviesDetailsScore.text = movie.vote_average.toString()
            moviesDetailsBodyOverview.text = movie.overview
        }
    }


}