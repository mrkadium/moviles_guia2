package com.example.guia2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.guia2.adapters.MovieAdapter
import com.example.guia2.adapters.ProductAdapter
import com.example.guia2.models.Movie
import com.example.guia2.models.Product

class MoviesActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: MovieAdapter
    lateinit var layout: LinearLayoutManager
    lateinit var listMovies:MutableList<Movie>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        loadMovies()
        adapter = MovieAdapter(listMovies)
        layout = LinearLayoutManager(this)
        recyclerView = findViewById(R.id.recvMovies)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = layout
        recyclerView.setHasFixedSize(true)
    }

    private fun loadMovies(){
        var list = mutableListOf(
            Movie(R.drawable.movie1, "Pantera Negra", "El rey de Wakanda debe enfrentar a una amenaza más grande.", "Mayores de 15 años", 5, 140),
            Movie(R.drawable.movie2, "La la land", "Una historia de amor y música.", "Todo público", 4, 30),
            Movie(R.drawable.movie3, "En el fin del mundo", "El capitán Jack Sparrow vuelve de entre los muertos.", "Mayores de 12 años", 5, 90),
            Movie(R.drawable.movie4, "El viaje de Chihiro", "Chihiro se pierde en un mundo mágico y debe salir de ahí", "Todo público", 3, 67)
        )
        listMovies = list
    }
}