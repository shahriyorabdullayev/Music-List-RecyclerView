package com.example.recyclerviewbestpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var mainRecyclerViewAdapter: MainRecyclerViewAdapter
    private lateinit var musicList:ArrayList<Music>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        musicList = ArrayList()

        for (i in 0..50) {
            musicList.add(Music("Shakhriyor", "Album 2022", R.drawable.im_music, R.raw.music1))
        }

        val mainRv = findViewById<RecyclerView>(R.id.recyclear_view_main)

        mainRecyclerViewAdapter = MainRecyclerViewAdapter(musicList, MainRecyclerViewAdapter.ItemClickListener {
            startPlayerActivity(it)

        })


        mainRv.adapter = mainRecyclerViewAdapter
            mainRv.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
            //layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)



    }
    fun startPlayerActivity(music: Music) {
        val intent = Intent(this@MainActivity, PlayerActivity::class.java)
        intent.putExtra("music", music)
        startActivity(intent)
    }


}