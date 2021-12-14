package com.example.rickandmortyapp.data.remote

import com.example.rickandmortyapp.data.entities.Character
import com.example.rickandmortyapp.data.entities.CharacterList
import com.example.rickandmortyapp.utils.Resource

class CloudDataSource(
    private val service: ApiService,
) : ICloudDataSource, BaseCloudDataSource() {
    override suspend fun fetchCharacters(): Resource<CharacterList> {
        val data: Resource<CharacterList> = getResult {
            service.fetchCharacters()
        }
        return data
    }
}