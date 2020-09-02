package com.example.guia2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.guia2.adapters.ProductAdapter
import com.example.guia2.models.Product

class Products : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter:ProductAdapter
    lateinit var layout:LinearLayoutManager
    lateinit var listProducts:MutableList<Product>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        loadProducts() //fills the product list
        adapter = ProductAdapter(listProducts)
        layout = LinearLayoutManager(this)
        recyclerView = findViewById(R.id.recvProducts)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = layout
        recyclerView.setHasFixedSize(true)
    }

    private fun loadProducts(){
        val list:MutableList<Product> = mutableListOf(
            Product(1, "Rebanada de pizza + Soda", 5.40, 0.2),
            Product(1, "Lasagna", 2.45),
            Product(1, "Pollo empanizado", 1.75)
        )
        listProducts = list
    }
}