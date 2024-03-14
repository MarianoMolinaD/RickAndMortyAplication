package com.portafoliowebmariano.rickandmortyapp.model.network

import com.portafoliowebmariano.rickandmortyapp.model.data.CharacterData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface CharacterApiClient {
    @GET
    suspend fun getAllCharacters(@Url url: String) : Response<CharacterData>
}