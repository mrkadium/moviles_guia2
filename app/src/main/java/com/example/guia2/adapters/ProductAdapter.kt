package com.example.guia2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.guia2.R
import com.example.guia2.models.Product
import com.example.guia2.viewHolders.ViewHolderProduct

class ProductAdapter(var data:List<Product>) : RecyclerView.Adapter<ViewHolderProduct>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderProduct {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ViewHolderProduct(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolderProduct, position: Int) {
        holder.tvName.text = data[position].name
        holder.tvLittlePrice.text = "$".plus(data[position].price.toString())
        holder.tvBigPrice.text = "$".plus(data[position].discountedPrice.toString())
        if(data[position].price == data[position].discountedPrice) holder.tvLittlePrice.visibility = View.GONE
    }

}