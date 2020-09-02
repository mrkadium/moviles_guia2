package com.example.guia2.viewHolders

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.guia2.R
import kotlinx.android.synthetic.main.product_item.view.*

class ViewHolderProduct(view: View): RecyclerView.ViewHolder(view){
    var tvName:TextView = itemView.findViewById(R.id.tvName)
    var tvLittlePrice:TextView = itemView.findViewById(R.id.tvLittlePrice)
    var tvBigPrice:TextView = itemView.findViewById(R.id.tvBigPrice)
}