package com.example.guia2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var etCorreo:EditText
    lateinit var etClave:EditText
    lateinit var btnIniciar:Button
    lateinit var btnExtra:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etCorreo = findViewById(R.id.etCorreo)
        etClave = findViewById(R.id.etClave)
        btnIniciar = findViewById(R.id.btnIniciar)
        btnExtra = findViewById(R.id.btnExtra)

        btnIniciar.setOnLongClickListener(){
            validateFields()
        }
        btnExtra.setOnClickListener{
            startActivity(Intent(this, Products::class.java))
        }
    }

    private fun validateFields():Boolean{
        var clear = false
        val errorText = "Debe llenar este campo"
        val textCorreo = etCorreo.text.trim()
        val textClave = etClave.text.trim()

        if(textCorreo.isNotEmpty() && textClave.isNotEmpty()) clear = true
        if(textCorreo.isEmpty()) etCorreo.error = errorText
        if(textClave.isEmpty()) etClave.error = errorText

        if(clear){
            var intent = Intent(this, Favoritos::class.java)
            startActivity(intent)
        }

        return clear
    }
}