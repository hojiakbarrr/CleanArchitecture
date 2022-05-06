package com.example.cleanarchitecture.data.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.cleanarchitecture.utils.const.Constants
import com.example.cleanarchitecture.utils.const.Constants.API_KEY
import com.example.cleanarchitecture.data.api.ApiService
import com.example.cleanarchitecture.data.model.films.MovieData
import retrofit2.HttpException

enum class ResponseType{
    POPULAR,UPCOMING,TOP_RATED,NOW_PLAYING,SEARCH
}

@Suppress("IMPLICIT_CAST_TO_ANY")
class MoviePagingSource(
    private val apiService: ApiService,

) : PagingSource<Int, MovieData>() {
    override fun getRefreshKey(state: PagingState<Int, MovieData>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val page = state.closestPageToPosition(anchorPosition) ?: return null
        return page.prevKey?.plus(1) ?: page.nextKey?.minus(1)
    }
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieData> {
        val page: Int = params.key ?: 1
        val pageSize: Int = params.loadSize.coerceAtMost(20)
        return try {

            val response =
               apiService.getPopularMovie(page)


            if (response.isSuccessful) {
                val movie = checkNotNull(response.body()?.results)
                val nextKey = if (movie.size < pageSize) null else page + 1
                val prevKey = if (page == 1) null else page - 1
                LoadResult.Page(movie, prevKey, nextKey)
            } else {
                LoadResult.Error(HttpException(response))
            }
        } catch (e: HttpException) {
            LoadResult.Error(e)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}