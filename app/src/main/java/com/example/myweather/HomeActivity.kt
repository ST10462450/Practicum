package com.example.myweather

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {

    // declarations and identifications of buttons and edit texts etc
    private lateinit var etDay : EditText
    private lateinit var etMin : EditText
    private lateinit var etMax : EditText
    private lateinit var etCondition : EditText

    // An array to store the weather information about the different days
    private val weatherData = ArrayList<weatherEntry>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        // reference the edit texts
        etDay = findViewById(R.id.etDay)
        etMin = findViewById(R.id.etMin)
        etMax =  findViewById(R.id.etMax)
        etCondition = findViewById(R.id.etCondition)

        // reference the buttons
        val buttonSave = findViewById<Button>(R.id.buttonSave)
        val buttonClear = findViewById<Button>(R.id.buttonClear)
        val buttonDetails = findViewById<Button>(R.id.buttonDetails)

        //save button functionality
        buttonSave.setOnClickListener{
            saveData() // calls save data function
        }
        buttonClear.setOnClickListener{
            clearData() // calls clear data function
        }
        buttonDetails.setOnClickListener{
            val intent = Intent(this, DetailedViewsActivity::class.java)
            // passing the weather data to the detailed screen
           intent.putParcelableArrayListExtra("data", weatherData)
            startActivity(intent)
        }

        }
    // defining the methods mentioned earlier
    private fun saveData(){
        val day = etDay.text.toString()
        val min = etMin.text.toString()
        val max = etMax.text.toString()
        val condition = etCondition.text.toString()

        // error message for missing field
        if (day.isEmpty() || min.isEmpty() || max.isEmpty() || condition.isEmpty()){
            Toast.makeText(this, "Please enter data in all the fields", Toast.LENGTH_SHORT).show()
            return
        }
            }
    private fun clearData(){
        etDay.text.clear()
        etMin.text.clear()
        etMax.text.clear()
        etCondition.text.clear()
            }
        }

private fun Any.putParcelableArrayListExtra(s: String, weatherData: ArrayList<weatherEntry>) {

}


