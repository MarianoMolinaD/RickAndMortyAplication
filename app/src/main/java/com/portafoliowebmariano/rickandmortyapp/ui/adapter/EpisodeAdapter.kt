package com.portafoliowebmariano.rickandmortyapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.portafoliowebmariano.rickandmortyapp.R
import com.portafoliowebmariano.rickandmortyapp.model.data.Episode

class EpisodeAdapter(private val listEpisodes : MutableList<Episode>) : RecyclerView.Adapter<EpisodeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return EpisodeViewHolder(layoutInflater.inflate(R.layout.items_episodes,parent,false))
    }

    override fun getItemCount(): Int = listEpisodes.size
    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
        val item = listEpisodes[position]
        holder.bin(item)
    }
}