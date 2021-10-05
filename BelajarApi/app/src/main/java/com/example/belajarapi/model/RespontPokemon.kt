package com.example.belajarapi.model

import com.google.gson.annotations.SerializedName

data class RespontPokemon(
//    fungsi sebagai untuk nama sesuai apa yang mau di cari d data base (Api)
    @field:SerializedName("count")
    val count: Int,
    @field:SerializedName("next")
    val next: String,
    @field:SerializedName("previous")
    val previous: String,
    @field:SerializedName("results")
    val listPokemon: ArrayList<Pokemon>
)
