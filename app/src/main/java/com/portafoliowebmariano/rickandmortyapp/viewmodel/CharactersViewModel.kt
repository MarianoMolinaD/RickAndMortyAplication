package com.portafoliowebmariano.rickandmortyapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.portafoliowebmariano.rickandmortyapp.model.Repository
import com.portafoliowebmariano.rickandmortyapp.model.data.Episode
import com.portafoliowebmariano.rickandmortyapp.model.data.Result
import com.portafoliowebmariano.rickandmortyapp.model.data.ResultList
import kotlinx.coroutines.launch

class CharactersViewModel() : ViewModel() {

    private val repository = Repository()

    var isStarting = MutableLiveData(false)
    var characterData = MutableLiveData<Result>()
    var characters = MutableLiveData<MutableList<ResultList>>()
    var listEpisodes = MutableLiveData<MutableList<Episode>>()

    fun getALlCharacters() {
        viewModelScope.launch {
            isStarting.postValue(true)
            try {
                characters.postValue(repository.getAllCharacters())
                isStarting.postValue(false)
            }catch (e: Exception){
                Log.i("Excepcion","No se pudo conectar")
            }
        }
    }
    fun getCharacterData(id: Int){
        viewModelScope.launch {
            characterData.postValue(repository.getCharacter(id))
        }
    }

    fun getListEpisodes(){
        viewModelScope.launch {
            listEpisodes.postValue(repository.getListEpisodes().results)
        }
    }
}