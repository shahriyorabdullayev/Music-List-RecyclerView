package com.example.recyclerviewbestpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var mainRecyclerViewAdapter: MainRecyclerViewAdapter
    private lateinit var musicList:ArrayList<Music>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        musicList = ArrayList()

        for (i in 0..50) {
            musicList.add(Music("Shakhriyor", "Album 2022", R.drawable.im_music))
        }

        mainRecyclerViewAdapter = MainRecyclerViewAdapter(musicList)

        findViewById<RecyclerView>(R.id.recyclear_view_main).apply {
            adapter = mainRecyclerViewAdapter
            layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        }


    }



}