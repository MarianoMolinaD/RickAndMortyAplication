package com.portafoliowebmariano.rickandmortyapp.model.network

import com.portafoliowebmariano.rickandmortyapp.core.RetrofitHelper
import com.portafoliowebmariano.rickandmortyapp.model.data.CharacterData
import com.portafoliowebmariano.rickandmortyapp.model.data.Episode
import com.portafoliowebmariano.rickandmortyapp.model.data.EpisodeData
import com.portafoliowebmariano.rickandmortyapp.model.data.Result
import com.portafoliowebmariano.rickandmortyapp.model.data.ResultList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.create

class CharactesServices {
    private val retrofit = RetrofitHelper.getRetrogit()
    fun getCharactersApi(): CharacterApiClient {
        return retrofit.create(CharacterApiClient::class.java)
    }
    suspend fun getCharacterApi(id:Int): Result {
        return withContext(Dispatchers.IO) {
            val response =
                retrofit.create(CharacterApiClient::class.java).getCharacter("character/$id")
            response.body()!!
        }
    }

    suspend fun getListEpisodes(): EpisodeData{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(CharacterApiClient::class.java).getEpisodes()
            response.body()!!
        }
    }
}