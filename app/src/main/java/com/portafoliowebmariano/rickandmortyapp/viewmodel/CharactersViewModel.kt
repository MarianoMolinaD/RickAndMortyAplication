package com.portafoliowebmariano.rickandmortyapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.portafoliowebmariano.rickandmortyapp.model.Repository
import com.portafoliowebmariano.rickandmortyapp.model.data.CharacterData
import com.portafoliowebmariano.rickandmortyapp.model.provider.CharactersProvider
import kotlinx.coroutines.launch

class CharactersViewModel() : ViewModel() {

    private val repository = Repository()

    var characters = MutableLiveData<CharacterData>()
    fun getALlCharacters() {
        viewModelScope.launch {
            val response = repository.getAllCharacters()
            characters.postValue(response)
        }
    }
}