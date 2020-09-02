package com.example.guia2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.guia2.adapters.ProductAdapter
import com.example.guia2.adapters.UserAdapter
import com.example.guia2.models.Product
import com.example.guia2.models.User

class Products : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter:ProductAdapter
    lateinit var layout:LinearLayoutManager
    lateinit var listProducts:MutableList<Product>

    lateinit var userAdapter:UserAdapter
    lateinit var lisvUsuarios:ListView
    lateinit var listUsers:MutableList<User>

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

        loadUsers()
        lisvUsuarios = findViewById(R.id.lisvUsuarios)
        userAdapter = UserAdapter(this, listUsers)
        lisvUsuarios.adapter = userAdapter
    }

    private fun loadProducts(){
        val list:MutableList<Product> = mutableListOf(
            Product(1, "Rebanada de pizza + Soda", 5.40, 0.2),
            Product(1, "Lasagna", 2.45),
            Product(1, "Pollo empanizado", 1.75)
        )
        listProducts = list
    }

    private fun loadUsers(){
        var list = mutableListOf(
            User("Mario Rivera Olivo","6301-6111","mario@gmail.com"),
            User("Adalberto Olivo","101 1111 01","adalberto@gmail.com"),
            User("Jane Doe","7070 9090","jane.doe@gmail.com"),
            User("John Doe","111 111 1","john.doe@gmail.com")
        )
        listUsers = list
    }
}