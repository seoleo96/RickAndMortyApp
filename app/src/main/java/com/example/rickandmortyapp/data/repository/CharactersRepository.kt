package com.example.rickandmortyapp.data.repository


import com.example.rickandmortyapp.data.entities.Character
import com.example.rickandmortyapp.data.remote.CloudDataSource
import com.example.rickandmortyapp.domain.repository.ICharactersRepository
import com.example.rickandmortyapp.utils.Resource
import com.example.rickandmortyapp.utils.performGetOperation
import kotlinx.coroutines.flow.Flow

class CharactersRepository(
    private val cloudDataSource: CloudDataSource,
) : ICharactersRepository {
    override suspend fun fetchCharacters(): Flow<Resource<List<Character>>> {
        return performGetOperation(
            networkCall = {
                Resource.success(cloudDataSource.fetchCharacters().data?.results ?: listOf())
            }
        )
    }
}