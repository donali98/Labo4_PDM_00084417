package com.deushdezt.labo4_pdm_00084417.activities.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.deushdezt.labo4_pdm_00084417.R
import com.deushdezt.labo4_pdm_00084417.activities.model.Movie
import kotlinx.android.synthetic.main.cardview_movie.view.*

class MovieAdapter(var movies: List<Movie>):RecyclerView.Adapter<MovieAdapter.ViewHolder> (){
    override fun onCreateViewHolder(parent: ViewGroup,  viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview_movie,parent,false);
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: ViewHolder, posicion: Int)  = holder.bind(movies[posicion])


    fun changeList(movies : List<Movie>){
        this.movies =  movies;
        notifyDataSetChanged()

    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        fun bind(movie: Movie) = with(itemView){
            Glide.with(itemView.context)
                .load(movie.Poster)
                .placeholder(R.drawable.ic_launcher_background)
                .into(movie_image_cv)
            movie_title_cv.text = movie.Title;
            movie_plot_cv.text = movie.Plot
            movie_rate_cv.text = movie.imdbRating
            movie_runtime_cv.text = movie.Runtime

        }
    }
}