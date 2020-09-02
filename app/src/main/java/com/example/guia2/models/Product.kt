package com.example.guia2.models

class Product(var id:Int, var name:String, var price:Double, var discount:Double = 0.0){
    var discountedPrice:Double = 0.0
        get() = price - (price*discount)
}