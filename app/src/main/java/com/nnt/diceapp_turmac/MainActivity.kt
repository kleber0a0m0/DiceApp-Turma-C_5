package com.nnt.diceapp_turmac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.chip.ChipGroup

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botao: Button = findViewById(R.id.botao)
        val imagemDoDado: ImageView = findViewById(R.id.imagem)

        val chipGroup: ChipGroup = findViewById(R.id.chip_group)

        chipGroup.setOnCheckedChangeListener { _, _ ->
            when(chipGroup.checkedChipId) {
                R.id.d4 -> imagemDoDado.setImageResource(R.drawable.d4_1)
                R.id.d6 -> imagemDoDado.setImageResource(R.drawable.d6_1)
                R.id.d8 -> imagemDoDado.setImageResource(R.drawable.d8_1)
                R.id.d10 -> imagemDoDado.setImageResource(R.drawable.d10_1)
                R.id.d12 -> imagemDoDado.setImageResource(R.drawable.d12_1)
                R.id.d20 -> imagemDoDado.setImageResource(R.drawable.d20_1)
            }
        }

        botao.setOnClickListener {
            jogarDado(imagemDoDado, chipGroup)
        }
    }
    private fun jogarDado(imagemDoDado: ImageView, chipGroup: ChipGroup) {
        var faceSorteada: Int
        val textoDaTela: TextView = findViewById(R.id.texto)

        when(chipGroup.checkedChipId) { //linha 39 escolhe um dado com o chipGroup.checkedChipId
            R.id.d4 -> { //se o dado escolhido for o d4...
                faceSorteada = (1..4).random()
                textoDaTela.text = resources.getString(R.string.text_view_face_sorteada, faceSorteada.toString())
                imagemDoDado.contentDescription = resources.getString(R.string.text_view_face_sorteada, faceSorteada.toString()) //para descrever a imagem para voiceover
                when(faceSorteada) {
                    1 -> imagemDoDado.setImageResource(R.drawable.d4_1)
                    2 -> imagemDoDado.setImageResource(R.drawable.d4_2)
                    3 -> imagemDoDado.setImageResource(R.drawable.d4_3)
                    4 -> imagemDoDado.setImageResource(R.drawable.d4_4)
                }
            }
            R.id.d6 -> { //se o dado escolhido for o d6...
                faceSorteada = (1..6).random()
                textoDaTela.text = resources.getString(R.string.text_view_face_sorteada, faceSorteada.toString())
                imagemDoDado.contentDescription = resources.getString(R.string.text_view_face_sorteada, faceSorteada.toString()) //para descrever a imagem para voiceover
                when(faceSorteada){
                    1 -> imagemDoDado.setImageResource(R.drawable.d6_1)
                    2 -> imagemDoDado.setImageResource(R.drawable.d6_2)
                    3 -> imagemDoDado.setImageResource(R.drawable.d6_3)
                    4 -> imagemDoDado.setImageResource(R.drawable.d6_4)
                    5 -> imagemDoDado.setImageResource(R.drawable.d6_5)
                    6 -> imagemDoDado.setImageResource(R.drawable.d6_6)
                }
            }
            R.id.d8 -> { //se o dado escolhido for o d6...
                faceSorteada = (1..8).random()
                textoDaTela.text = resources.getString(R.string.text_view_face_sorteada, faceSorteada.toString())
                imagemDoDado.contentDescription = resources.getString(R.string.text_view_face_sorteada, faceSorteada.toString()) //para descrever a imagem para voiceover
                when(faceSorteada) {
                    1 -> imagemDoDado.setImageResource(R.drawable.d8_1)
                    2 -> imagemDoDado.setImageResource(R.drawable.d8_2)
                    3 -> imagemDoDado.setImageResource(R.drawable.d8_3)
                    4 -> imagemDoDado.setImageResource(R.drawable.d8_4)
                    5 -> imagemDoDado.setImageResource(R.drawable.d8_5)
                    6 -> imagemDoDado.setImageResource(R.drawable.d8_6)
                    7 -> imagemDoDado.setImageResource(R.drawable.d8_7)
                    8 -> imagemDoDado.setImageResource(R.drawable.d8_8)
                }
            }
            R.id.d10 -> { //se o dado escolhido for o d6... (complete)

            }
            R.id.d12 -> { //se o dado escolhido for o d6... (complete)

            }
            R.id.d20 -> { //se o dado escolhido for o d6... (complete)

            }
        }
    }
}

