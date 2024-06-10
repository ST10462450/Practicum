package com.example.myweather

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)

        findViewById<Button>(R.id.buttonEnter).setOnClickListener {
            //Retrieve user input from edit text fields
            val etName = findViewById<EditText>(R.id.etName)
            val etStudentNumber = findViewById<EditText>(R.id.etStudentNumber)

            val name = etName.text.toString()
            val studentNumber = etStudentNumber.text.toString()

            // start MainActivity and pass your input as extras
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("student number", studentNumber)
            startActivity(intent)
            finish()
        }
        findViewById<Button>(R.id.buttonExit).setOnClickListener{
            finish()
        }
    }
}