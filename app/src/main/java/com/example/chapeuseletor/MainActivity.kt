package com.example.chapeuseletor
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
// 1. Pegar as referências dos elementos da tela (Views)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroupCasas)
        val button = findViewById<Button>(R.id.btnSortear)

        button.setOnClickListener {
            val idSelecionado = radioGroup.checkedRadioButtonId

            if (idSelecionado == -1) {
                Toast.makeText(this, "Por favor, selecione uma opção!", Toast.LENGTH_SHORT).show()
            } else {
                val casa = when (idSelecionado) {
                    R.id.radioCoragem -> "Grifinória"
                    R.id.radioSabedoria -> "Corvinal"
                    R.id.radioAmbicao -> "Sonserina"
                    R.id.radioLealdade -> "Lufa-Lufa"
                    else -> "Indefinida"
                }

                val intent = Intent(this, ResultadoActivity::class.java)
                intent.putExtra("EXTRA_CASA_NOME", casa)
                startActivity(intent)
            }
        }
// 3. Descobrir qual RadioButton foi selecionado
            val idSelecionado = radioGroup.checkedRadioButtonId
// 4. Verificar se alguma opção foi realmente selecionada
            if (idSelecionado == -1) {
// Mostra uma mensagem de erro se nada foi selecionado
                Toast.makeText(this, "Por favor, selecione uma opção!", Toast.LENGTH_SHORT).show()
            } else {
// 5. Determinar a casa com base na seleção
                val casa = when (idSelecionado) {
                    R.id.radioCoragem -> "Grifinória!"
                    R.id.radioSabedoria -> "Corvinal!"
                    R.id.radioAmbicao -> "Sonserina!"
                    R.id.radioLealdade -> "Lufa-Lufa!"
                    else -> "Casa Indefinida" // Caso de segurança, não deve acontecer
                }
// 6. Exibir o resultado em um Toast
                Toast.makeText(this, "Você pertence à... $casa", Toast.LENGTH_LONG).show()
            }
        }
    }
