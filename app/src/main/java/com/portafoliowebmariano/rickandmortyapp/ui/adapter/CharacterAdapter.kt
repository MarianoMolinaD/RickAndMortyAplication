package com.portafoliowebmariano.rickandmortyapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.portafoliowebmariano.rickandmortyapp.R
import com.portafoliowebmariano.rickandmortyapp.model.data.ResultList

class CharacterAdapter (private var character: MutableList<ResultList>, private val onclickItem:(id: Int)-> Unit): RecyclerView.Adapter<CharacterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CharacterViewHolder(layoutInflater.inflate(R.layout.items_character, parent, false))
    }

    override fun getItemCount(): Int = character.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val item : ResultList = character[position]
        holder.bin(item, onclickItem)
    }
}