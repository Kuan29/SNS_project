package com.example.sns_project

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sns_project.StoryAdapter.StoryViewHolder as StoryViewHolder

class StoryAdapter(val itemList: ArrayList<StoryItem>) : RecyclerView.Adapter<StoryAdapter.StoryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_story_view,parent,false)
        return StoryViewHolder(view)
    }
    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        holder.name.text = itemList[position].name
        //Glide.with(holder.itemView.context).load(itemList[position].imgurl).into(holder.img)
    }
    override fun getItemCount(): Int {
        return itemList.count()
    }

    inner class StoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val img = itemView.findViewById<ImageView>(R.id.item_story_view_img)
        val name = itemView.findViewById<TextView>(R.id.item_story_view_name)



    }
}