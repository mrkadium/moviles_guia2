package com.example.guia2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.*
import java.io.Console
import java.lang.Exception

class Favoritos : AppCompatActivity() {
    //VIEWS
    lateinit var actFavFruta:AutoCompleteTextView
    lateinit var actFavAnimal:AutoCompleteTextView
    lateinit var actFavLenguaje:AutoCompleteTextView
    lateinit var pbProgreso:ProgressBar
    lateinit var btnProcesar:Button

    //CONSTANTES
    val LIST_COMIDA:Array<String> = arrayOf("Piña", "Manzana", "Banana", "Fresa", "Uva", "Sandía")
    val LIST_ANIMALES:Array<String> = arrayOf("Perro", "Lobo", "Jirafa", "Tiburón", "Ballena", "Tortuga")
    val LIST_LENGUAJES:Array<String> = arrayOf("Python", "Javascript", "Java", "C++", "Swift", "Kotlin")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favoritos)

        actFavFruta = findViewById(R.id.actFavFruta)
        actFavAnimal = findViewById(R.id.actFavAnimal)
        actFavLenguaje = findViewById(R.id.actFavLenguaje)
        pbProgreso = findViewById(R.id.pbProgreso)
        btnProcesar = findViewById(R.id.btnProcesar)

        setAdapters()

        btnProcesar.setOnClickListener(){
            processData()
        }
    }

    //ADAPTADORES
    fun setAdapters(){
        var frutaAdapter:ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, LIST_COMIDA)
        actFavFruta.setAdapter(frutaAdapter)
        var animalesAdapter:ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, LIST_ANIMALES)
        actFavAnimal.setAdapter(animalesAdapter)
        var lenguajesAdapter:ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, LIST_LENGUAJES)
        actFavLenguaje.setAdapter(lenguajesAdapter)
    }

    fun processData(){
        pbProgreso.progress = 0
        pbProgreso.max = 100
        var handler:Handler = Handler()

        Thread(Runnable {
            run{
                var progress:Int = 0
                while (progress < 100){
                    try {
                        Thread.sleep(75)
                    }catch (ex:InterruptedException){
                        ex.printStackTrace()
                    }
                    progress += 1

                    var finalProgress:Int = progress
                    handler.post(Runnable {
                        run{
                            pbProgreso.progress = finalProgress
                        }
                    })
                }
                //tuve que hacer esto, sino no funcionaba, me daba error "Can't toast on a thread that has not called Looper.prepare()"
                //según entiendo, si quiero imprimir Toasts en un hilo tengo que usar runOnUiThread()
                runOnUiThread(){
                    showToasts()
                }
            }
        }).start()
    }

    fun showToasts(){
        Toast.makeText(this, "Fruta: ${actFavFruta.text}", Toast.LENGTH_LONG).show()
        Toast.makeText(this, "Animal: ${actFavAnimal.text}", Toast.LENGTH_LONG).show()
        Toast.makeText(this, "Lenguaje de programación: ${actFavLenguaje.text}", Toast.LENGTH_LONG).show()
    }
}