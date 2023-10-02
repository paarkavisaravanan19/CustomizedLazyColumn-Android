package com.example.customlazycolumn.data

import java.io.Serializable

data class Books (
    val id: Int,
    val title: String,
    val author : String,
    val publishedyear : Int,
    val description : String,
    val BookImageId : Int =0
) : Serializable