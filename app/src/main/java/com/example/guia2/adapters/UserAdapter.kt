package com.example.guia2.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.guia2.R
import com.example.guia2.models.User

class UserAdapter(var context:Context, var data:List<User>): BaseAdapter() {
    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): Any {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view:View = LayoutInflater.from(context).inflate(R.layout.usuario_item, null)

        val currentUser:User = data[position]
        val tvUser:TextView = view.findViewById(R.id.tvUser)
        val tvPhone:TextView = view.findViewById(R.id.tvPhone)
        val tvEmail:TextView = view.findViewById(R.id.tvEmail)

        tvUser.text = currentUser.user
        tvPhone.text = currentUser.phone
        tvEmail.text = currentUser.email

        return view
    }

}