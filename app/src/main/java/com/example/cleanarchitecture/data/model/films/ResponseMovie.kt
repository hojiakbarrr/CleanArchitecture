package com.example.cleanarchitecture.data.model.films

data class ResponseMovie(
    val page: Int,
    val results: List<MovieData>,
    val total_pages: Int,
    val total_results: Int
)
