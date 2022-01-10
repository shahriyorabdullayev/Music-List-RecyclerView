package com.example.recyclerviewbestpractice

import java.io.Serializable

data class Music(
    val title:String,
    val album:String,
    val image: Int,
    val file: Int
): Serializable
