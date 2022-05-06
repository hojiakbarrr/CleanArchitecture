package com.example.cleanarchitecture.presentation.mapper

import com.example.cleanarchitecture.core.base.Mapper
import com.example.cleanarchitecture.domain.model.MovieDomain
import com.example.cleanarchitecture.presentation.model.Movie

class MovieMapper : Mapper<MovieDomain, Movie>() {
    override fun map(from: MovieDomain): Movie = from.run {
        Movie(
            adult= adult,
            id = id,
            original_language = original_language,
            original_title = original_title,
            overview = overview,
            popularity = popularity,
            poster_path = poster_path,
            release_date = release_date,
            title = title,
            video = video,
            vote_average = vote_average,
            vote_count = vote_count
        )
    }
}