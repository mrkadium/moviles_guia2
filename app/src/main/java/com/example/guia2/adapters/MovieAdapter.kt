package com.example.guia2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.guia2.R
import com.example.guia2.models.Movie
import com.example.guia2.viewHolders.ViewHolderMovie

class MovieAdapter(var data:List<Movie>): RecyclerView.Adapter<ViewHolderMovie>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderMovie {
        var view:View = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return ViewHolderMovie(view)
    }

    override fun onBindViewHolder(holder: ViewHolderMovie, position: Int) {
        holder.poster.setImageResource(data[position].poster)
        holder.titulo.text = data[position].titulo
        holder.descripcion.text = data[position].descripcion
        holder.clasificacion.text = data[position].clasificacion

        var starCount = data[position].stars
        var stars = mutableListOf(holder.star1, holder.star2, holder.star3, holder.star4, holder.star5)
        for((index, star) in stars.withIndex()){
            if(index+1 <= starCount) star.setImageResource(android.R.drawable.star_on)
            else star.setImageResource(android.R.drawable.star_off)
        }

        holder.votos.text = data[position].votos.toString().plus(" votos")
    }

    override fun getItemCount(): Int {
        return data.size
    }

}