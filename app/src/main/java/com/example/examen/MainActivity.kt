package com.example.examen

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var crvEntrar : Button
    private lateinit var crvSalir : Button
    private lateinit var txtNombre: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        IniciarComponentes()
        eventosClick()
    }
    fun IniciarComponentes(){
        crvEntrar = findViewById(R.id.crvEntrar) as Button
        crvSalir = findViewById(R.id.crvSalir) as Button
        txtNombre = findViewById(R.id.txtNombre)
    }
    private fun eventosClick() {
        crvEntrar.setOnClickListener {
            val nombre = txtNombre.text.toString()
            if (nombre.isEmpty()) {
                Toast.makeText(this, "Por favor, ingresa tu nombre", Toast.LENGTH_SHORT).show()
            } else {
                // Enviar nombre a la actividad Rectangulo
                val intent = Intent(this, Rectangulo::class.java)
                intent.putExtra("NOMBRE", nombre)
                startActivity(intent)
            }
        }
        crvSalir.setOnClickListener {
            finish()
        }

    }
}