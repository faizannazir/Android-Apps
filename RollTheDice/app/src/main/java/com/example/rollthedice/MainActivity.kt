package com.example.rollthedice

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.happybirthday.R


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        val result: TextView = findViewById(R.id.textView)
        val diceImage: ImageView = findViewById(R.id.imageView)
        diceImage.setImageResource((R.drawable.dice_1 .. R.drawable.dice_6).random())
        rollButton.setOnClickListener {
//            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
//            toast.show()
//            result.text = "Rolled"

            val diceValue = rollDice().also {
                diceImage.contentDescription =  it.toString()
                result.text = it.toString()
            }
            val drawableResource = when(diceValue)
            {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }

            diceImage.setImageResource(drawableResource)
        }
    }

    private fun rollDice() : Int{
        val dice = Dice(6)
         return dice.roll()
    }
}


class Dice(private val number: Int)
{
    fun roll() :Int
    {
        return (1..number).random()
    }
}