package com.example.myweather

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailedViewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_views)

        val data = intent.getParcelableArrayListExtra<weatherEntry>("data") ?: arrayListOf()
        val listView = findViewById<ListView>(R.id.myListView)
        val averageTextView = findViewById<TextView>(R.id.AvgTextView)
        val btnBack = findViewById<Button>(R.id.buttonBack)

        // calculation of the average temperature
        var SumMin = 0.0
        var SumMax = 0.0
        data.forEach{
            SumMin += it.min
            SumMax += it.max
        }
        val averageMax = if(data.isNotEmpty())SumMax / data.size else 0.0
        val averageMin = if(data.isNotEmpty())SumMin / data.size else 0.0
        averageTextView.text = "Average Maximum Temperature: $averageMax\n Average Minimum Temperature: $averageMin"

        //List View
        val detailedList = data.map { "day: ${it.day}\n Minimum Temp: ${it.min}\n Maximum Temp: ${it.max} Condition: ${it.condition}" }
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, detailedList)
        listView.adapter = adapter

        btnBack.setOnClickListener{
            finish()
        }
        }
    }
