package com.example.calculadora

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import com.example.calculadora.ResActivity
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var spinnerFacultad: Spinner
    private lateinit var btnCalcular: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinnerFacultad = findViewById(R.id.spinnerFacultad)
        btnCalcular = findViewById(R.id.btnCalcular)

        val facultades = arrayOf("Ciencias Económicas", "Ingeniería y Sistemas", "Arte y Diseño", "Ciencias Sociales", "Ciencias Jurídicas")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, facultades)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerFacultad.adapter = adapter

        btnCalcular.setOnClickListener {
            calcularNotas()
        }
    }

    private fun calcularNotas() {
        val nombre = findViewById<EditText>(R.id.etNombre).text.toString()
        val apellido = findViewById<EditText>(R.id.etApellido).text.toString()
        val telefono = findViewById<EditText>(R.id.etTelefono).text.toString()
        val carnet = findViewById<EditText>(R.id.etCarnet).text.toString()
        val facultad = spinnerFacultad.selectedItem.toString()
        val anioIngreso = findViewById<EditText>(R.id.etAnioIngreso).text.toString()

        val lab1 = findViewById<EditText>(R.id.etLab1).text.toString().toFloatOrNull() ?: 0f
        val lab2 = findViewById<EditText>(R.id.etLab2).text.toString().toFloatOrNull() ?: 0f
        val lab3 = findViewById<EditText>(R.id.etLab3).text.toString().toFloatOrNull() ?: 0f
        val lab4 = findViewById<EditText>(R.id.etLab4).text.toString().toFloatOrNull() ?: 0f
        val parcial1 = findViewById<EditText>(R.id.etParcial1).text.toString().toFloatOrNull() ?: 0f
        val parcial2 = findViewById<EditText>(R.id.etParcial2).text.toString().toFloatOrNull() ?: 0f
        val parcial3 = findViewById<EditText>(R.id.etParcial3).text.toString().toFloatOrNull() ?: 0f
        val parcial4 = findViewById<EditText>(R.id.etParcial4).text.toString().toFloatOrNull() ?: 0f

        val promedioLabs = (lab1 + lab2 + lab3 + lab4) / 4 * 0.4f
        val promedioParciales = (parcial1 + parcial2 + parcial3 + parcial4) / 4 * 0.6f
        val promedioFinal = promedioLabs + promedioParciales

        val intent = Intent(this, ResActivity::class.java)
        intent.putExtra("NOMBRE", nombre)
        intent.putExtra("APELLIDO", apellido)
        intent.putExtra("TELEFONO", telefono)
        intent.putExtra("CARNET", carnet)
        intent.putExtra("FACULTAD", facultad)
        intent.putExtra("ANIO_INGRESO", anioIngreso)
        intent.putExtra("LAB1", lab1)
        intent.putExtra("LAB2", lab2)
        intent.putExtra("LAB3", lab3)
        intent.putExtra("LAB4", lab4)
        intent.putExtra("PARCIAL1", parcial1)
        intent.putExtra("PARCIAL2", parcial2)
        intent.putExtra("PARCIAL3", parcial3)
        intent.putExtra("PARCIAL4", parcial4)
        intent.putExtra("PROMEDIO_FINAL", promedioFinal)
        startActivity(intent)
    }
}