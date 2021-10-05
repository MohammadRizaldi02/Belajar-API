package com.example.belajarapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.belajarapi.databinding.ActivityMainBinding
import com.example.belajarapi.model.Pokemon
import com.example.belajarapi.model.PokemonAdapter
import com.example.belajarapi.model.RespontPokemon
import com.example.belajarapi.network.RetrofitAdd
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: PokemonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pokemonService = RetrofitAdd.getPokemonService()
        pokemonService.getAllPokemon().enqueue(object : Callback<RespontPokemon> {
            override fun onResponse(
                call: Call<RespontPokemon>,
                response: Response<RespontPokemon>
            ) {
                if (response.isSuccessful) {
                    Log.d("data", "${response.body()}")
                    val data = response.body()
                    initiateRecyclerview(data?.listPokemon!!)
                } else {
                    Log.e("not succes", "TIDAK BERHASIl")
                }
            }

            override fun onFailure(call: Call<RespontPokemon>, t: Throwable) {
                t.message?.let { Log.e("error", it) }
            }
        })
    }

    fun initiateRecyclerview(listPokemon: ArrayList<Pokemon>) {
        adapter = PokemonAdapter(listPokemon)
        binding.rvPokemon.adapter = adapter
        binding.rvPokemon.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}