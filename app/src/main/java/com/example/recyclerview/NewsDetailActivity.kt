package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class NewsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

        val heading = intent.getStringExtra("heading")
        val content = intent.getStringExtra("content")
        val imageId = intent.getIntExtra("imageId" , R.drawable.newsimg1)

        val headingView = findViewById<TextView>(R.id.newsHeading)
        val headingImageView = findViewById<ImageView>(R.id.newsImage)
        val newsContentTextView = findViewById<TextView>(R.id.newsContent)
        headingView.text = heading
        newsContentTextView.text = content
        headingImageView.setImageResource(imageId)
    }
}