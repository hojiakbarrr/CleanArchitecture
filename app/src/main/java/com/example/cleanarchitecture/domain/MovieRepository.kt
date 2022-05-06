package com.example.cleanarchitecture.domain

import androidx.paging.PagingData
import com.example.cleanarchitecture.core.Resource
import com.example.cleanarchitecture.data.model.detail.MovieDetail
import com.example.cleanarchitecture.data.model.films.MovieData
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface MovieRepository {
    fun getAllMovie(): Flow<PagingData<MovieData>>

     fun getMovieDetails(id: Int, ru: String) : Flow<Resource<MovieDetail>>
}