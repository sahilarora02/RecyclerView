package com.example.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var myRecyclerView: RecyclerView
    lateinit var newsArrayList: ArrayList<News>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         supportActionBar?.hide()
        myRecyclerView = findViewById(R.id.recyclerView)

        var newsImageArray = arrayOf(
         R.drawable.newsimg1 ,
            R.drawable.newsimg2 ,
            R.drawable.newsimg3,
            R.drawable.newsimg4,
            R.drawable.newsimg5
        )

        var newsHeadingArray = arrayOf(
            "U.K. Foreign Secretary James Cleverly raises issue of BBC tax searches with EAM Jaishankar",
            "Cooking gas prices hiked by ₹50 for domestic, ₹350.50 for commercial cylinders",
            "Joe Biden appoints two prominent Indian-American corporate leaders to his Export Council",
            "Sergey Lavrov will raise suspected bombing of Nord Stream II at G20: Russian Foreign Ministry",
            "Belarusian leader Lukashenko visits China amid Ukraine tensions"
        )
        val newsContent = arrayOf(
            getString(R.string.news_content),
            getString(R.string.news_content),
            getString(R.string.news_content),
            getString(R.string.news_content),
            getString(R.string.news_content)

        )

     myRecyclerView.layoutManager = LinearLayoutManager(this)
        newsArrayList = arrayListOf<News>()

        for( index in newsImageArray.indices){
            val news = News(newsHeadingArray[index] , newsImageArray[index] , newsContent[index])
            newsArrayList.add(news)
        }
        var myAdapter = MyAdapter(newsArrayList , this)
        myRecyclerView.adapter = myAdapter
        myAdapter.setItemClickListerner(object : MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                // on clicking each Item, what action u want to perform
                val intent = Intent(applicationContext , NewsDetailActivity::class.java)
                intent.putExtra("heading" , newsArrayList[position].newsHeading)
                intent.putExtra("imageId" , newsArrayList[position].newsImage)
                intent.putExtra("content" , newsArrayList[position].newsContent)
                startActivity(intent)
            }

        })
    }
}