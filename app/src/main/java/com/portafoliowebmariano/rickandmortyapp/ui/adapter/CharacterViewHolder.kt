package com.portafoliowebmariano.rickandmortyapp.ui.adapter

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.portafoliowebmariano.rickandmortyapp.R
import com.portafoliowebmariano.rickandmortyapp.databinding.ItemsCharacterBinding
import com.portafoliowebmariano.rickandmortyapp.model.data.ResultList
import com.squareup.picasso.Picasso

class CharacterViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val binding = ItemsCharacterBinding.bind(view)
    fun bin(item: ResultList, onclickItem: (id: Int) -> Unit) {
        binding.tvName.text = item.name
        binding.tvGender.text = item.gender
        binding.tvSpecies.text = item.species
        binding.tvLocation.text = item.location.name
        binding.tvNumber.text = "# ${item.id}"
        Picasso.get().load(item.image).into(binding.ivCharacter)

        itemView.setOnClickListener {
            onclickItem(item.id)
        }
        when (item.status){
            "Alive" -> binding.flStatus.setBackgroundColor(
                ContextCompat.getColor(
                    binding.flStatus.context,
                    R.color.backgrounAlive
                )
            )
            "Dead" -> binding.flStatus.setBackgroundColor(
                ContextCompat.getColor(
                    binding.flStatus.context,
                    R.color.backgrounDead
                )
            )
            "unknown" -> binding.flStatus.setBackgroundColor(
                ContextCompat.getColor(
                    binding.flStatus.context,
                    R.color.backgrounUnknown
                )
            )
        }
    }
}