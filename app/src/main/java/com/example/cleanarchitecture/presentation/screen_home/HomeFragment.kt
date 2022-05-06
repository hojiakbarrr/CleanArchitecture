package com.example.cleanarchitecture.presentation.screen_home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.cleanarchitecture.core.base.BaseFragment
import com.example.cleanarchitecture.databinding.HomeFragmentBinding
import com.example.cleanarchitecture.presentation.model.Movie
import com.example.cleanarchitecture.presentation.screen_home.adapter.MovieAdapter
import com.example.cleanarchitecture.presentation.screen_home.adapter.MovieItemOnClickListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeFragmentBinding, HomeViewModel>(HomeFragmentBinding::inflate),
    MovieItemOnClickListener {


    private val adapter: MovieAdapter by lazy {
        MovieAdapter(this)
    }

    override val viewModel: HomeViewModel by viewModels()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding().recMovies.adapter = adapter
        lifecycleScope.launch {
            viewModel.movies.collectLatest(adapter::submitData)
        }

    }

    override fun showDetailsMovie(movie: Movie) {
        viewModel.goDetails(movie)

    }


}