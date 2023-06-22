package com.nnt.diceapp_turmac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textoDaTela: TextView = findViewById(R.id.texto)
        val botao: Button = findViewById(R.id.botao)
        val imagemDoDado: ImageView = findViewById(R.id.imagem)

        var faceSorteada = 1

        botao.setOnClickListener {
            faceSorteada = (1..6).random()
            textoDaTela.text = faceSorteada.toString()
            when(faceSorteada){
                1 -> imagemDoDado.setImageResource(R.drawable.d6_1)
                2 -> imagemDoDado.setImageResource(R.drawable.d6_2)
                3 -> imagemDoDado.setImageResource(R.drawable.d6_3)
                4 -> imagemDoDado.setImageResource(R.drawable.d6_4)
                5 -> imagemDoDado.setImageResource(R.drawable.d6_5)
                6 -> imagemDoDado.setImageResource(R.drawable.d6_6)
            }

        }
    }
}

