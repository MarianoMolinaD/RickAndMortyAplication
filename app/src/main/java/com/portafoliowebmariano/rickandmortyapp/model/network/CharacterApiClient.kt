package com.portafoliowebmariano.rickandmortyapp.model.network

import com.portafoliowebmariano.rickandmortyapp.model.data.CharacterData
import retrofit2.Response
import retrofit2.http.GET

interface CharacterApiClient {
    @GET("character")
    suspend fun getAllCharacters() : Response<CharacterData>
}