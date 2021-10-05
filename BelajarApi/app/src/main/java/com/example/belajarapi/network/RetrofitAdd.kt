package com.example.belajarapi.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitAdd {
    companion object {
        private const val BASE_URL = "https://pokeapi.co/api/v2/"

        private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        fun getPokemonService(): PokemonService {
            return retrofit.create(PokemonService::class.java)
        }
    }
}