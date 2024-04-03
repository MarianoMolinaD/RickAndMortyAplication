package com.portafoliowebmariano.rickandmortyapp.model

import com.portafoliowebmariano.rickandmortyapp.model.data.CharacterData
import com.portafoliowebmariano.rickandmortyapp.model.data.EpisodeData
import com.portafoliowebmariano.rickandmortyapp.model.data.Result
import com.portafoliowebmariano.rickandmortyapp.model.data.ResultList
import com.portafoliowebmariano.rickandmortyapp.model.network.CharactesServices
import com.portafoliowebmariano.rickandmortyapp.model.provider.CharactersProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.IDN

class Repository {
    private val api = CharactesServices()
    private var provider = CharactersProvider.CharactersRM
    suspend fun getAllCharacters(): MutableList<ResultList> {
        return withContext(Dispatchers.IO) {
            api.getCharactersApi().getAllCharacters()
        }
    }

    suspend fun getCharacter(id: Int): Result {
        return withContext(Dispatchers.IO) {
            val response = api.getCharacterApi(id)
            response
        }
    }

    suspend fun getListEpisodes(): EpisodeData {
        return withContext(Dispatchers.IO) {
            val response = api.getListEpisodes()
            response
        }
    }
}