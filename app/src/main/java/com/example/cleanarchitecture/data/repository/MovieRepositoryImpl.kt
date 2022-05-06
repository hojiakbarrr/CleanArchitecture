package com.example.cleanarchitecture.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.cleanarchitecture.core.Resource
import com.example.cleanarchitecture.core.Status
import com.example.cleanarchitecture.data.api.ApiService
import com.example.cleanarchitecture.data.base.BaseApiResponse
import com.example.cleanarchitecture.data.model.detail.MovieDetail
import com.example.cleanarchitecture.data.model.films.MovieData
import com.example.cleanarchitecture.data.source.MoviePagingSource
import com.example.cleanarchitecture.domain.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class MovieRepositoryImpl @Inject constructor(private val dataSource: MoviePagingSource, val apiService: ApiService): MovieRepository ,BaseApiResponse(){


    override fun getAllMovie(): Flow<PagingData<MovieData>> = Pager(PagingConfig(5)){dataSource}.flow


    override  fun getMovieDetails(id: Int, ru: String): Flow<Resource<MovieDetail>> = flow  {
        emit(Resource.loading())
        val response = safeApiCall {  apiService.getMoviesDetails(id,ru) }
        when(response.status){
            Status.SUCCESS -> emit(Resource.success(response.data!!))
            Status.ERROR -> emit(Resource.error(message = response.message!!))
        }
    }
}