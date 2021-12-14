package com.example.rickandmortyapp.domain.repository

import com.example.rickandmortyapp.data.entities.Character
import com.example.rickandmortyapp.utils.Resource
import kotlinx.coroutines.flow.Flow

interface ICharactersRepository {
    suspend fun fetchCharacters() : Flow<Resource<List<Character>>>
}