package com.example.calculadora

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_res)

        val nombre = intent.getStringExtra("NOMBRE") ?: ""
        val apellido = intent.getStringExtra("APELLIDO") ?: ""
        val carnet = intent.getStringExtra("CARNET") ?: ""
        val facultad = intent.getStringExtra("FACULTAD") ?: ""
        val anioIngreso = intent.getStringExtra("ANIO_INGRESO") ?: ""
        val lab1 = intent.getFloatExtra("LAB1", 0f)
        val lab2 = intent.getFloatExtra("LAB2", 0f)
        val lab3 = intent.getFloatExtra("LAB3", 0f)
        val lab4 = intent.getFloatExtra("LAB4", 0f)
        val parcial1 = intent.getFloatExtra("PARCIAL1", 0f)
        val parcial2 = intent.getFloatExtra("PARCIAL2", 0f)
        val parcial3 = intent.getFloatExtra("PARCIAL3", 0f)
        val parcial4 = intent.getFloatExtra("PARCIAL4", 0f)
        val promedioFinal = intent.getFloatExtra("PROMEDIO_FINAL", 0f)

        val resultadoTextView = findViewById<TextView>(R.id.tvResultado)
        resultadoTextView.text = """
            El estudiante $nombre $apellido con carnet $carnet de la Facultad de $facultad que estudia desde el año $anioIngreso.
            Ha obtenido las siguientes calificaciones:
            
            Laboratorios:
            Lab 1: $lab1
            Lab 2: $lab2
            Lab 3: $lab3
            Lab 4: $lab4
            
            Parciales:
            Parcial 1: $parcial1
            Parcial 2: $parcial2
            Parcial 3: $parcial3
            Parcial 4: $parcial4
            
            Promedio final: ${String.format("%.2f", promedioFinal)}
        """.trimIndent()
    }
}