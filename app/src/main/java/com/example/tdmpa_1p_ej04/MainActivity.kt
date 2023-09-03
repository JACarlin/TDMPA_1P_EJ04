package com.example.tdmpa_1p_ej04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var txtDivisas = findViewById<TextView>(R.id.txtDivisas)
        txtDivisas.text = impremeDivisas()
        var txtEmpresas = findViewById<TextView>(R.id.txtEmpresas)
        empresasInit()
        txtEmpresas.text = imprimeEmpresas()
        var btnEmp = findViewById<Button>(R.id.btnEmp)
        btnEmp.setOnClickListener {
            var txtEmp = findViewById<EditText>(R.id.txtEmp)

            for (i in empresas.indices){
                if(txtEmp.text.toString() == empresas.get(i)){
                    var toast = Toast.makeText(this,"La empresa ya esta registrada",
                        Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            }
            empresas.add(txtEmp.text.toString())
            txtEmpresas.text = imprimeEmpresas()

        }
    }
    var divisas : List<String> = listOf("MXN","USD","EUP")
    var empresas : MutableList<String> = mutableListOf("Apple","Microsoft","Google")

    fun empresasInit(){
        empresas.add("Oracle")
        empresas.remove("Google")
        empresas.removeAt(0)

    }
    fun impremeDivisas():String{
        var cadena = ""
        for (i in divisas){
            cadena = cadena + i + " | "
        }

        return cadena
    }
    fun imprimeEmpresas(): String{
        var cadena = ""
        for (i in  0 .. empresas.size-1){
            cadena = cadena + "${i+1}: ${empresas[i]} \n"
        }
        return cadena
    }

}