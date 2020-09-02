package com.example.guia2.viewHolders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.guia2.R

class ViewHolderMovie(view:View): RecyclerView.ViewHolder(view) {
    var poster:ImageView = itemView.findViewById(R.id.poster)
    var titulo:TextView = itemView.findViewById(R.id.titulo)
    var descripcion:TextView = itemView.findViewById(R.id.descripcion)
    var clasificacion:TextView = itemView.findViewById(R.id.clasificacion)
    var star1:ImageView = itemView.findViewById(R.id.star1)
    var star2:ImageView = itemView.findViewById(R.id.star2)
    var star3:ImageView = itemView.findViewById(R.id.star3)
    var star4:ImageView = itemView.findViewById(R.id.star4)
    var star5:ImageView = itemView.findViewById(R.id.star5)
    var votos:TextView = itemView.findViewById(R.id.votos)
}