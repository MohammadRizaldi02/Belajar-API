package com.example.belajarapi.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.belajarapi.databinding.PokemonItemBinding

class PokemonAdapter(private val listPokemon: ArrayList<Pokemon>) :
    RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>() {

    inner class PokemonViewHolder(private val binding: PokemonItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pokemon: Pokemon) {
            binding.tvNamaPokemon.text = pokemon.name
            binding.tvUrlPokemin.text = pokemon.url
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PokemonViewHolder {
        val binding = PokemonItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PokemonViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listPokemon.size
    }

    override fun onBindViewHolder(holder: PokemonAdapter.PokemonViewHolder, position: Int) {
        holder.bind(listPokemon[position])
    }

}