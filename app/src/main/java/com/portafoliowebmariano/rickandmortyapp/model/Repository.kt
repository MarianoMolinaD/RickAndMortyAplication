package com.portafoliowebmariano.rickandmortyapp.model

import com.portafoliowebmariano.rickandmortyapp.model.data.CharacterData
import com.portafoliowebmariano.rickandmortyapp.model.data.Result
import com.portafoliowebmariano.rickandmortyapp.model.network.CharactesServices
import com.portafoliowebmariano.rickandmortyapp.model.provider.CharactersProvider

class Repository {
    private val api = CharactesServices()

    suspend fun getAllCharacters(): CharacterData {
        var responseCharacters = api.getCharactersApi()
        var currenteCharacters = CharactersProvider.CharactersRM
        currenteCharacters = responseCharacters
        return currenteCharacters
    }
}