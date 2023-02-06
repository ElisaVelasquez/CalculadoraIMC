package com.example.asignacion4_calculadoraimc_velasquez

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        //Declaracion de variables
        val alturaE: EditText = findViewById(R.id.height)
        val pesoK: EditText = findViewById(R.id.weight)
        val imc: TextView = findViewById(R.id.imc)
        val rango: TextView = findViewById(R.id.range)
        val Calcular: Button = findViewById(R.id.calcular)

        Calcular.setOnClickListener {
                var peso = 0.0
                var estatura = 0.0

                try{
                    estatura=alturaE.text.toString().toDouble()
                    peso=pesoK.text.toString().toDouble()
                }catch(e: java.lang.Exception){
                    imc.text = "Debe ingresar valores reales"
                    println(e)

                }

                val resultado=calcularIMC(estatura,peso)
                val formattedNumber="%.2f".format(resultado)
                imc.text = formattedNumber

                val salud: String
                val color: Int


                when{
                    resultado < 18.5 -> {
                        salud="Bajo peso"
                        color= R.color.colorRed
                    }
                    resultado in 18.5..24.9 -> {
                        salud="Saludable"
                        color= R.color.colorGreenish
                    }
                    resultado > 24.9 && resultado <= 29.9 -> {
                        salud="Sobrepeso"
                        color= R.color.colorYellow
                    }
                    resultado > 29.9 && resultado <= 34.9 -> {
                        salud="Obesidad Grado 1"
                        color= R.color.colorOrange
                    }
                    resultado > 34.9 && resultado <= 39.9 -> {
                        salud="Obesidad Grado 2"
                        color= R.color.colorBrown
                    }
                    resultado >= 40 -> {
                        salud="Obesidad Grado 3"
                        color= R.color.colorRed
                    }
                    else ->{
                        salud="Error"
                        color= 0
                    }
                }
                rango.setBackgroundResource(color)
                rango.text = salud

            }

        }

    /**
     * Esta funcion calcula el IMC
     */
    fun calcularIMC(height: Double, weight: Double): Double {

        return weight/(height*height)

    }

}