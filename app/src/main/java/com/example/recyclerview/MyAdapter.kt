package com.example.recyclerview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.google.android.material.imageview.ShapeableImageView
import org.w3c.dom.Text
import java.lang.reflect.Type
import java.text.FieldPosition

class MyAdapter(var newsArrayList: ArrayList<News> , var context : Activity) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

// create new view instance when layoutmanager fails to find a suitable View for each time
    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int):MyAdapter.MyViewHolder {
 val itemView = LayoutInflater.from(parent.context).inflate(R.layout.eachrow , parent ,false)
    return MyViewHolder(itemView)

    }
    // Populates items with data
    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder , position: Int) {
val currentItem = newsArrayList[position]
 holder.hTitle.text = currentItem.newsHeading
        holder.hImage.setImageResource(currentItem.newsImage)
    }
    // how many list items are present in your array
    override fun getItemCount(): Int {
       return newsArrayList.size
    }

    //it holds the view ,so views are not created every time to save memory
    class MyViewHolder(itemView:View) :RecyclerView.ViewHolder(itemView) {
    val hTitle = itemView.findViewById<TextView>(R.id.headingTitle)
        val hImage = itemView.findViewById<ShapeableImageView>(R.id.headingImage)
    }

}