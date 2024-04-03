package com.portafoliowebmariano.rickandmortyapp.model.data

data class ResultList(
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val species: String,
    val status: String,
)