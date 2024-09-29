package com.tnbk00.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var diceImage: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        val rollButton2: Button = findViewById(R.id.roll_button_2)
        rollButton.setOnClickListener {
            diceImage = findViewById(R.id.dice_image)
            rollDice()
        }
        rollButton2.setOnClickListener {
            diceImage = findViewById(R.id.dice_image_2)
            rollDice()
         }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun rollDice() {
        val randomInt = Random().nextInt(6) +1
        val drawableResource = when (randomInt) {
            1 -> R.drawable.d6_1
            2 -> R.drawable.d6_2
            3 -> R.drawable.d6_3
            4 -> R.drawable.d6_4
            5 -> R.drawable.d6_5
            else -> R.drawable.d6_6
        }
        diceImage.setImageResource(drawableResource)
    }
}