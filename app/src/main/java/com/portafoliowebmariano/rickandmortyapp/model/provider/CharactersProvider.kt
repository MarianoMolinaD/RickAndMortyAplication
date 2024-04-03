package com.portafoliowebmariano.rickandmortyapp.model.provider

import com.portafoliowebmariano.rickandmortyapp.model.data.CharacterData
import com.portafoliowebmariano.rickandmortyapp.model.data.Result
import com.portafoliowebmariano.rickandmortyapp.model.data.ResultList

class CharactersProvider {
    companion object {
        var CharactersRM: MutableList<ResultList>? = null
    }
}