package com.example.cleanarchitecture.domain

import androidx.paging.map
import com.example.cleanarchitecture.core.base.Mapper
import com.example.cleanarchitecture.data.model.films.MovieData
import com.example.cleanarchitecture.domain.model.MovieDomain
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetDetailsMovieUseCase @Inject constructor(private val repository: MovieRepository, private val mapper: Mapper<MovieData, MovieDomain>){


    fun execute(id: Int, ru: String) = repository.getMovieDetails(id, ru)
}