package com.nnt.diceapp_turmac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.google.android.material.chip.ChipGroup
import com.nnt.diceapp_turmac.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var isAnimating = false
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val botao: Button = findViewById(R.id.botao)
        //val imagemDoDado: ImageView = findViewById(R.id.imagem)

        val chipGroup: ChipGroup = findViewById(R.id.chip_group)

        binding.imagem.setImageResource(R.drawable.d4_1)

        chipGroup.setOnCheckedChangeListener { _, _ ->
            when(chipGroup.checkedChipId) {
                R.id.d4 -> binding.imagem.setImageResource(R.drawable.d4_1)
                R.id.d6 -> binding.imagem.setImageResource(R.drawable.d6_1)
                R.id.d8 -> binding.imagem.setImageResource(R.drawable.d8_1)
                R.id.d10 -> binding.imagem.setImageResource(R.drawable.d10_1)
                R.id.d12 -> binding.imagem.setImageResource(R.drawable.d12_1)
                R.id.d20 -> binding.imagem.setImageResource(R.drawable.d20_1)
            }
        }

        binding.botao.setOnClickListener {
            jogarDado(binding.imagem, chipGroup)
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
                    1 -> mudaImagem(R.drawable.d4_1, imagemDoDado)
                    2 -> mudaImagem(R.drawable.d4_2, imagemDoDado)
                    3 -> mudaImagem(R.drawable.d4_3, imagemDoDado)
                    4 -> mudaImagem(R.drawable.d4_4, imagemDoDado)
                }
            }
            R.id.d6 -> { //se o dado escolhido for o d6...
                faceSorteada = (1..6).random()
                textoDaTela.text = resources.getString(R.string.text_view_face_sorteada, faceSorteada.toString())
                imagemDoDado.contentDescription = resources.getString(R.string.text_view_face_sorteada, faceSorteada.toString()) //para descrever a imagem para voiceover
                when(faceSorteada){
                    1 -> mudaImagem(R.drawable.d6_1, imagemDoDado)
                    2 -> mudaImagem(R.drawable.d6_2, imagemDoDado)
                    3 -> mudaImagem(R.drawable.d6_3, imagemDoDado)
                    4 -> mudaImagem(R.drawable.d6_4, imagemDoDado)
                    5 -> mudaImagem(R.drawable.d6_5, imagemDoDado)
                    6 -> mudaImagem(R.drawable.d6_6, imagemDoDado)
                }
            }
            R.id.d8 -> { //se o dado escolhido for o d6...
                faceSorteada = (1..8).random()
                textoDaTela.text = resources.getString(R.string.text_view_face_sorteada, faceSorteada.toString())
                imagemDoDado.contentDescription = resources.getString(R.string.text_view_face_sorteada, faceSorteada.toString()) //para descrever a imagem para voiceover
                when(faceSorteada) {
                    1 -> mudaImagem(R.drawable.d8_1, imagemDoDado)
                    2 -> mudaImagem(R.drawable.d8_2, imagemDoDado)
                    3 -> mudaImagem(R.drawable.d8_3, imagemDoDado)
                    4 -> mudaImagem(R.drawable.d8_4, imagemDoDado)
                    5 -> mudaImagem(R.drawable.d8_5, imagemDoDado)
                    6 -> mudaImagem(R.drawable.d8_6, imagemDoDado)
                    7 -> mudaImagem(R.drawable.d8_7, imagemDoDado)
                    8 -> mudaImagem(R.drawable.d8_8, imagemDoDado)
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

    private fun mudaImagem(iDResoursesImagem: Int, imagemDoDado: ImageView){
        if(!isAnimating) {
            isAnimating = true
            imagemDoDado.animate().apply {
                duration = 500
                //rotationYBy(360f)
                scaleX(0f)
                scaleY(0f)
                //alpha(0f)
            }.withEndAction {
                imagemDoDado.animate().apply {
                    //alpha(1f)
                    scaleX(1f)
                    scaleY(1f)
                }
                imagemDoDado.setImageResource(iDResoursesImagem)
                isAnimating = false
            }.start()
        }
    }
}

