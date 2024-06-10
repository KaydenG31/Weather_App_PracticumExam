package com.kayden.weatherapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

   // Array Days of the week with tempretures
    private val minTemps = arrayOf(12, 15, 8, 11, 12, 10, 10)
    private val maxTemps = arrayOf(25, 29, 20, 27, 30, 18, 16)
    private val conditions = arrayOf("Sunny", "Sunny", "Raining", "Partly Cloudy", "Sunny", "Raining", "Cold")

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enableEdgeToEdge()

        val btnCalculateAvg: Button = findViewById(R.id.btnCalculateAvg)
        val btnViewDetails: Button = findViewById(R.id.btnViewDetails)
        val btnClearData: Button = findViewById(R.id.btnClearData)
        val btnExit: Button = findViewById(R.id.btnExit)
        val txtAvgTemp: TextView = findViewById(R.id.txtAvgTemp)

        btnCalculateAvg.setOnClickListener {
            val avgTemp = calculateAverageTemperature(minTemps, maxTemps)
            txtAvgTemp.text = "Average Temperature: $avgTemp°C"
        }

        btnViewDetails.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }

        btnClearData.setOnClickListener {
            clearData()
            txtAvgTemp.text = ""
        }

        btnExit.setOnClickListener {
            finish()
        }
    }

    //Loop to calculate average tempreture
    private fun calculateAverageTemperature(minTemps: Array<Int>, maxTemps: Array<Int>): Double {
        var totalTemp = 0.0
        for (i in minTemps.indices) {
            totalTemp += (minTemps[i] + maxTemps[i]) / 2.0
        }
        return totalTemp / minTemps.size
    }

    private fun clearData() {
        for (i in minTemps.indices) {
            minTemps[i] = 0
            maxTemps[i] = 0
            conditions[i] = ""
        }
    }
}
