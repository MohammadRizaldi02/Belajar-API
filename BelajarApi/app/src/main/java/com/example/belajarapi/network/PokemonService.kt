package com.example.belajarapi.network

import com.example.belajarapi.model.RespontPokemon
import retrofit2.Call
import retrofit2.http.GET

interface PokemonService {
    //buat manggil data" pokemon
    //ambilpaling blkang
    //data tersebut ada di respon pokemon

    @GET("pokemon")
    fun getAllPokemon(): Call<RespontPokemon>
}