package com.example.cleanarchitecture.presentation.screen_home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.map
import com.example.cleanarchitecture.core.base.BaseViewModel
import com.example.cleanarchitecture.core.base.Mapper
import com.example.cleanarchitecture.domain.GetPopularMovieUseCase
import com.example.cleanarchitecture.domain.maper.MovieDomainMapper
import com.example.cleanarchitecture.domain.model.MovieDomain
import com.example.cleanarchitecture.presentation.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    useCase: GetPopularMovieUseCase,
    private val mapper: Mapper<MovieDomain, Movie>
) : BaseViewModel() {

    fun goDetails(movie: Movie) = navigate(HomeFragmentDirections.fromHomeFragmentToMovieDetailsFragment(movie))

    val movies: StateFlow<
            PagingData<Movie>> = useCase.execute().map {
        it.map {
            mapper.map(it)
        }
    }.stateIn(viewModelScope, SharingStarted.Lazily, PagingData.empty())

}