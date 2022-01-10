package com.example.recyclerviewbestpractice

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class PlayerActivity : AppCompatActivity() {
    private lateinit var music: Music
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        music = getSerializabeleExtra()
        initViews()
    }

    private fun initViews() {
        val tvTitle = findViewById<TextView>(R.id.tv_title_music1);
        val tvAlbum = findViewById<TextView>(R.id.tv_album_music1)
        val imageMusic = findViewById<ImageView>(R.id.img_music1)
        val playButton = findViewById<Button>(R.id.btn_play_music)

        tvTitle.text = music.title
        tvAlbum.text = music.album
        imageMusic.setImageResource(music.image)

        mediaPlayer = MediaPlayer.create(this, music.file)

        playButton.setOnClickListener {
            if(!mediaPlayer.isPlaying){
                mediaPlayer.start()
            }else {
                mediaPlayer.pause()
            }

        }

    }


    fun getSerializabeleExtra(): Music {
        return intent.getSerializableExtra("music") as Music
    }

    override fun onPause() {
        super.onPause()

    }





}