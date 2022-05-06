package com.example.cleanarchitecture.core.di

import com.example.cleanarchitecture.data.api.ApiService
import com.example.cleanarchitecture.data.repository.MovieRepositoryImpl
import com.example.cleanarchitecture.data.source.MoviePagingSource
import com.example.cleanarchitecture.domain.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providePagingSource(apiService: ApiService) : MoviePagingSource = MoviePagingSource(apiService)

    @Provides
    @Singleton
    fun provideMoviesRepository(dataSource: MoviePagingSource, apiService: ApiService): MovieRepository = MovieRepositoryImpl(dataSource, apiService)



}
