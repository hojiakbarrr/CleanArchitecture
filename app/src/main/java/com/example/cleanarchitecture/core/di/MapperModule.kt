package com.example.cleanarchitecture.core.di

import com.example.cleanarchitecture.core.base.Mapper
import com.example.cleanarchitecture.data.model.films.MovieData
import com.example.cleanarchitecture.domain.maper.MovieDomainMapper
import com.example.cleanarchitecture.domain.model.MovieDomain
import com.example.cleanarchitecture.presentation.mapper.MovieMapper
import com.example.cleanarchitecture.presentation.model.Movie
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

    @Provides
    @Singleton
    fun provideMovieDomainMapper(): Mapper<MovieData, MovieDomain> = MovieDomainMapper()


    @Provides
    @Singleton
    fun provideMovieMapper() : Mapper<MovieDomain, Movie> = MovieMapper()


//    @Provides
//    @Singleton
//    fun provideMovieDetailsMapper() : Mapper<MovieDomain, Movie> = MovieMapper()



}