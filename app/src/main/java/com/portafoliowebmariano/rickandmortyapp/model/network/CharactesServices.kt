package com.portafoliowebmariano.rickandmortyapp.model.network

import com.portafoliowebmariano.rickandmortyapp.core.RetrofitHelper
import com.portafoliowebmariano.rickandmortyapp.model.data.CharacterData
import com.portafoliowebmariano.rickandmortyapp.model.data.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharactesServices {
    private val retrofit = RetrofitHelper.getRetrogit()

    suspend fun getCharactersApi(): CharacterData{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(CharacterApiClient::class.java).getAllCharacters()
            response.body()!!
        }
    }

}