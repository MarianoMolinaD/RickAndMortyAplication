package com.portafoliowebmariano.rickandmortyapp.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.portafoliowebmariano.rickandmortyapp.databinding.ItemsEpisodesBinding
import com.portafoliowebmariano.rickandmortyapp.model.data.Episode

class EpisodeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemsEpisodesBinding.bind(view)
    fun bin(item: Episode) {
        binding.tvEpisode.text = item.episode
        binding.tvName.text = item.name
        binding.tvAirDate.text = item.air_date
    }
}