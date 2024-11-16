package com.example.examen

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Rectangulo : AppCompatActivity() {
    private lateinit var txtSaludo: TextView
    private lateinit var Base: EditText
    private lateinit var Altura: EditText
    private lateinit var Area: TextView
    private lateinit var Perimetro: TextView
    private lateinit var btnLimpiar: Button
    private lateinit var btnRegresar: Button
    private lateinit var btnCalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_rectangulo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }
        IniciarComponentes()
        val nombre = intent.getStringExtra("NOMBRE")
        txtSaludo.text = "Hola, $nombre"
        eventosClick()
    }

    private fun IniciarComponentes() {
        txtSaludo = findViewById(R.id.txtSaludo);
        Base = findViewById(R.id.Base);
        Altura = findViewById(R.id.Altura);
        Area = findViewById(R.id.Area);
        Perimetro = findViewById(R.id.Perimetro);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnRegresar = findViewById(R.id.btnRegresar);
        btnLimpiar = findViewById(R.id.btnLimpiar);

    }

    private fun eventosClick() {
        btnCalcular.setOnClickListener {
            val baseText = Base.text.toString()
            val alturaText = Altura.text.toString()

            if (baseText.isEmpty() || alturaText.isEmpty()) {
                Toast.makeText(this, "Falta capturar información", Toast.LENGTH_SHORT).show()
            } else {
                val base = baseText.toFloat()
                val altura = alturaText.toFloat()
                val area = base * altura
                val perimetro = 2 * (base + altura)

                Area.text = "Área: $area"
                Perimetro.text = "Perímetro: $perimetro"
            }
        }

        btnLimpiar.setOnClickListener {
            Area.text = "Área:"
            Perimetro.text = "Perímetro:"
            Base.text.clear()
            Altura.text.clear()
        }

        btnRegresar.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Cálculo del Rectángulo")
            builder.setMessage("¿Desea salir?")
            builder.setPositiveButton("Aceptar") { _, _ ->
                finish()

            }
            builder.setNegativeButton("Cancelar") { dialog, _ ->
                dialog.dismiss()
            }
            builder.create().show()
        }
    }
}
