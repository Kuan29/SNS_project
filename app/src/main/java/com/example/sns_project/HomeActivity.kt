package com.example.sns_project

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sns_project.databinding.ActivityHomeBinding
import com.example.sns_project.databinding.ActivityLoginBinding
import java.util.UUID

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)

        val itemlist = ArrayList<StoryItem>()
        val storyAdapter = StoryAdapter(itemlist)
        storyAdapter.notifyDataSetChanged()

        itemlist.add(StoryItem("안범준"))
        itemlist.add(StoryItem("양간마"))
        itemlist.add(StoryItem("윤석열"))
        itemlist.add(StoryItem("이재명"))
        binding.homestoryRecy.adapter = storyAdapter
        binding.homestoryRecy.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)

        val uuid = UUID.randomUUID().toString()


    }
    fun story(){

    }
}