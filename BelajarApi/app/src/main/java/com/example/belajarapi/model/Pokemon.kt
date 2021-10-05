package com.example.belajarapi.model

import com.google.gson.annotations.SerializedName

data class Pokemon(
    @field:SerializedName("name")
    val name: String,
    @field:SerializedName("url")
    val url: String
)
