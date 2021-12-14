package com.example.rickandmortyapp.data.remote

import com.example.rickandmortyapp.data.entities.Character
import com.example.rickandmortyapp.data.entities.CharacterList
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("character")
    suspend fun fetchCharacters() : Response<CharacterList>
}