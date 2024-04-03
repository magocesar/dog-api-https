package com.example.dog_api

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var randomFact : TextView
    lateinit var refreshButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        randomFact = findViewById(R.id.RamdomDogFact)
        refreshButton = findViewById(R.id.GetDogFact)

        fetchDogFact()

        refreshButton.setOnClickListener {
            fetchDogFact()
        }
    }

    private fun fetchDogFact() {
        lifecycleScope.launch {
            val response = RandomDogFactApiService.service.getDogFact()
            if (response.isSuccessful) {
                val fact = response.body()
                randomFact.text = fact?.facts?.get(0)
            }
        }
    }
}