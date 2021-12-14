package com.example.rickandmortyapp.data.remote

import com.example.rickandmortyapp.data.entities.Character
import com.example.rickandmortyapp.data.entities.CharacterList
import com.example.rickandmortyapp.utils.Resource
import retrofit2.Response

interface ICloudDataSource {
    suspend fun fetchCharacters(): Resource<CharacterList>
}