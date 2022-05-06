package com.example.cleanarchitecture.data.api

import com.example.cleanarchitecture.utils.const.Constants
import com.example.cleanarchitecture.data.model.actors_detail.Actor_detail
import com.example.cleanarchitecture.data.model.detail.MovieDetail
import com.example.cleanarchitecture.data.model.films.ResponseMovie
import com.example.cleanarchitecture.data.model.person.ResponseActor
import com.example.cleanarchitecture.data.model.trailer.TrailerResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET(Constants.POPULAR)
    suspend fun getPopularMovie(
        @Query("page") page: Int,
    ): Response<ResponseMovie>

    @GET(Constants.UPCOMING)
    suspend fun getUpcomingMovies(
        @Query("api_key") apikey: String,
        @Query("page") page: Int,
    ): Response<ResponseMovie>

    @GET(Constants.TOP_RATED)
    suspend fun getTopRatedMovies(
        @Query("api_key") apikey: String,
        @Query("page") page: Int,
    ): Response<ResponseMovie>

    @GET(Constants.NOW_PLAYING)
    suspend fun getNowPlayingMovies(
        @Query("api_key") apikey: String,
        @Query("page") page: Int,
    ): Response<ResponseMovie>

    @GET(Constants.MOVIE_DETAILS)
    suspend fun getMoviesDetails(
        @Path("movie_id") movieId: Int,
        @Query("language") language:String,
    ): Response<MovieDetail>

    @GET(Constants.MOVIE_TRAILERS)
    suspend fun getMovieTrailer(
        @Path("movie_id") id: Int,
        @Query("language") language: String,
        @Query("api_key") apikey: String
    ): Response<TrailerResponse>

    @GET(Constants.SEARCH_MOVIE)
    suspend fun getSearchMovie(
        @Query("api_key") api_key: String,
        @Query("query") name: String,
    ): Response<ResponseMovie>

    @GET(Constants.POPULAR_ACTORS)
    suspend fun getPerson(
        @Query("api_key") api_key: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): Response<ResponseActor>

    @GET(Constants.SEARCH_ACTOR)
    suspend fun getSearchActor(
        @Query("api_key") api_key: String,
        @Query("language") language: String,
        @Query("query") name: String,
    ): Response<ResponseActor>

    @GET(Constants.ACTORS_DETAILS)
    suspend fun getActorsDetails(
        @Path("person_id") personId: Int,
        @Query("language")language:String,
        @Query("api_key") api_key: String,
    ): Response<Actor_detail>

}