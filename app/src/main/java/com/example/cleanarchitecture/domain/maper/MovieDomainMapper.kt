package com.example.cleanarchitecture.domain.maper

import com.example.cleanarchitecture.core.base.Mapper
import com.example.cleanarchitecture.data.model.films.MovieData
import com.example.cleanarchitecture.domain.model.MovieDomain

class MovieDomainMapper : Mapper<MovieData, MovieDomain>() {
    override fun map(from: MovieData): MovieDomain = from.run {
        MovieDomain(
            adult,
            id,
            original_language,
            original_title,
            overview,
            popularity,
            poster_path,
            release_date,
            title,
            video,
            vote_average,
            vote_count
        )
    }
}