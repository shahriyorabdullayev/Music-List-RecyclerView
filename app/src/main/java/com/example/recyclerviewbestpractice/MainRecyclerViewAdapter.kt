package com.example.recyclerviewbestpractice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainRecyclerViewAdapter(val musicsList :ArrayList<Music>, val itemClickListener: ItemClickListener) :
    RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_music, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val music = musicsList[position]

        holder.apply {
            albumTextView.text = music.album
            titleTextView.text = music.title
            imageView.setImageResource(music.image)
        }

        holder.view.setOnClickListener {
            itemClickListener.onClick(music)

        }

    }

    override fun getItemCount(): Int = musicsList.size

    class ItemClickListener(val callBack: (music: Music) -> Unit) {
        fun onClick(music: Music) = callBack(music)


    }

    class ViewHolder(val view : View): RecyclerView.ViewHolder(view){
        val imageView = view.findViewById<ImageView>(R.id.image_music)
        val titleTextView = view.findViewById<TextView>(R.id.tv_title_music)
        val albumTextView = view.findViewById<TextView>(R.id.tv_album_music)




    }
}