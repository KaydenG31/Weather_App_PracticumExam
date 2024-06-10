package com.kayden.weatherapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.ListView

class DetailActivity : AppCompatActivity() {
    private val daysOfWeek = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    private val minTemps = arrayOf(12, 15, 8, 11, 12, 10, 10)
    private val maxTemps = arrayOf(25, 29, 20, 27, 30, 18, 16)
    private val conditions = arrayOf("Sunny", "Sunny", "Raining", "Partly Cloudy", "Sunny", "Raining", "Cold")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        enableEdgeToEdge()

        val listView: ListView = findViewById(R.id.listView)

        val detailsList = mutableListOf<String>()
        for (i in daysOfWeek.indices) {
            detailsList.add("${daysOfWeek[i]}: Min ${minTemps[i]}°C, Max ${maxTemps[i]}°C, Condition: ${conditions[i]}")
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, detailsList)
        listView.adapter = adapter
    }
}
