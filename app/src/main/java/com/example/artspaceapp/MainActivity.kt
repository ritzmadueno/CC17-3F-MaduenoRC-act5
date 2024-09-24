package com.example.artspaceapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val imageView = arrayOf(
        R.drawable.couple,
        R.drawable.hehe,
        R.drawable.jesus,
        R.drawable.mona,
        R.drawable.vang,
    )

    private val textView = arrayOf(
        "American Gothic",
        "Wizja Artysy",
        "Salvator Mundi ",
        "Mona Lisa",
        "Vincent Vang Gogh",
    )

    private var currentIndex = 0

    private lateinit var artImageView: ImageView
    private lateinit var descriptionTextView: TextView
    private lateinit var nextButton: Button
    private lateinit var prevButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        artImageView = findViewById(R.id.imageView)
        descriptionTextView = findViewById(R.id.textView3)  // Updated to match XML
        nextButton = findViewById(R.id.button2)
        prevButton = findViewById(R.id.button)


        updateContent()


        nextButton.setOnClickListener { changeContent(1) }
        prevButton.setOnClickListener { changeContent(-1) }
    }

    private fun updateContent() {
        artImageView.setImageResource(imageView[currentIndex])
        descriptionTextView.text = textView[currentIndex]
    }

    private fun changeContent(direction: Int) {
        currentIndex = (currentIndex + direction).coerceIn(0, imageView.size - 1)
        updateContent()
    }
}