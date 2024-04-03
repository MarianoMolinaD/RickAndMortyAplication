package com.portafoliowebmariano.rickandmortyapp.model.network
import com.portafoliowebmariano.rickandmortyapp.model.data.EpisodeData
import com.portafoliowebmariano.rickandmortyapp.model.data.Result
import com.portafoliowebmariano.rickandmortyapp.model.data.ResultList
import com.portafoliowebmariano.rickandmortyapp.utlis.Constans.ENDPOINT_ALL_CHARACTERS
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface CharacterApiClient {
    @GET(ENDPOINT_ALL_CHARACTERS)
    suspend fun getAllCharacters():MutableList<ResultList>

    @GET()
    suspend fun getCharacter(@Url url: String): Response<Result>

    @GET("episode")
    suspend fun getEpisodes(): Response<EpisodeData>

}