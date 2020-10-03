package com.teste.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var num1: Double = 0.0
    private var num2: Double = 0.0
    private var num3: Double = 0.0
    private var contador = 0
    private var total: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        zero.setOnClickListener{clickButton("0")}
        um.setOnClickListener{clickButton("1")}
        dois.setOnClickListener{clickButton("2")}
        tres.setOnClickListener{clickButton("3")}
        quatro.setOnClickListener{clickButton("4")}
        cinco.setOnClickListener{clickButton("5")}
        seis.setOnClickListener{clickButton("6")}
        sete.setOnClickListener{clickButton("7")}
        oito.setOnClickListener{clickButton("8")}
        nove.setOnClickListener{clickButton("9")}

        soma.setOnClickListener{verificarOpe(SOMA)}
        subtra.setOnClickListener{verificarOpe(SUB)}
        vezes.setOnClickListener{verificarOpe(MULT)}
        dividir.setOnClickListener{verificarOpe(DIV)}

        clearBtn.setOnClickListener {
            num1 = 0.0
            num2 = 0.0
            resultado.text = ""
            total = NO_OPERATION
            operacaovisual.text = "="
        }

        igual.setOnClickListener {

            val result = when(total){
                SUB -> (num1 - num2)
                DIV ->(num1 / num2)
                SOMA -> (num1 + num2)
                MULT -> (num1 * num2)
                else -> num1
            }

            resultado.text = result.toString()


        }
    }

    private fun clickButton(digito: String) {
        resultado.text = "${resultado.text}${digito}"

        if(total == NO_OPERATION){
            num1 = resultado.text.toString().toDouble()
        }else{
            num2 = resultado.text.toString().toDouble()
        }
    }

    private fun verificarOpe(operation: Int){
        total = operation
        num1 = resultado.text.toString().toDouble()

        when(total){
            SUB -> operacaovisual.text = "-"
            DIV -> operacaovisual.text = "/"
            SOMA -> operacaovisual.text = "+"
            MULT -> operacaovisual.text = "x"
            else -> operacaovisual.text = "="
        }

        resultado.text = " "

    }

    companion object{
        const val SOMA = 1
        const val MULT = 2
        const val DIV = 3
        const val SUB = 4
        const val NO_OPERATION = 0
    }
}