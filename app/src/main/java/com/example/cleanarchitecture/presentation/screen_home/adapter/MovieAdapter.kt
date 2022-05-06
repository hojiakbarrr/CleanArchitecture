package com.example.cleanarchitecture.presentation.screen_home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.databinding.ItemMovieBinding
import com.example.cleanarchitecture.presentation.model.Movie
import com.example.cleanarchitecture.presentation.screen_home.adapter.MovieAdapter.*
import com.example.cleanarchitecture.utils.const.Constants.POSTER_BASE_URL
import com.squareup.picasso.Picasso
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject

interface MovieItemOnClickListener {
    fun showDetailsMovie(movie: Movie)
}
class MovieAdapter (
    private val actionListener: MovieItemOnClickListener,
) : PagingDataAdapter<Movie, MovieAdapter.HomeNewsViewHolder>(MovieDiffItemCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeNewsViewHolder {
        val inflater =
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        val binding = ItemMovieBinding.bind(inflater)
        return HomeNewsViewHolder(binding)
    }
    override fun onBindViewHolder(holder: HomeNewsViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }
    inner class HomeNewsViewHolder(private val binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("NotifyDataSetChanged")
        fun bind(movie: Movie) {
            val rating = movie.vote_average * 10
            binding.apply {
                cvMovieReleaseDate.text = movie.release_date
                cvMovieTitle.text = movie.title
                val moviePosterURL = POSTER_BASE_URL + movie.poster_path
                Picasso.get()
                    .load(moviePosterURL)
                    .resize(200, 200)
                    .into(cvIvMoviePoster)
                progressView.setProgress(rating.toInt())
                when {
                    rating >= 70 -> {
                        progressView.setProgressColorRes(R.color.green)
                    }
                    rating.toInt() in 41..69 -> {
                        progressView.setProgressColorRes(R.color.orange)
                    }
                    else -> {
                        progressView.setProgressColorRes(R.color.red)
                    }
                }
            }
            itemView.setOnClickListener {
                actionListener.showDetailsMovie(movie = movie)
            }
        }
    }
}
private object MovieDiffItemCallback : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }
    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem.title == newItem.title && oldItem.id == newItem.id
    }
}