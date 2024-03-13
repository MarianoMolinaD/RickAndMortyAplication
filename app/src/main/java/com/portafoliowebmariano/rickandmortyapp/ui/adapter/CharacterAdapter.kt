package com.portafoliowebmariano.rickandmortyapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.portafoliowebmariano.rickandmortyapp.R
import com.portafoliowebmariano.rickandmortyapp.model.data.Result

class CharacterAdapter (private var character: List<Result>): RecyclerView.Adapter<CharacterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CharacterViewHolder(layoutInflater.inflate(R.layout.items_character, parent, false))
    }

    override fun getItemCount(): Int = character.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val item : Result = character[position]
        holder.bin(item)
    }
}