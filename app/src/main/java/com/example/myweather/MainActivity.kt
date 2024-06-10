package com.example.myweather

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val intent = intent
        val name = intent.getStringExtra("name")
        val studentNumber = intent.getStringExtra("student number")

        val textView = findViewById<TextView>(R.id.InfoText)
        textView.text = "Name: $name \n Student Number: $studentNumber"

        val buttonGoToHome = findViewById<Button>(R.id.buttonHome)
        buttonGoToHome.setOnClickListener{
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        }
    }
