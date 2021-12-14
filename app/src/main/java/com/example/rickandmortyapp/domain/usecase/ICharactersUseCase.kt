package com.example.rickandmortyapp.domain.usecase

import com.example.rickandmortyapp.data.entities.Character
import com.example.rickandmortyapp.utils.Resource
import kotlinx.coroutines.flow.Flow


interface ICharactersUseCase {
    suspend fun fetchCharacters() : Flow<Resource<List<Character>>>
}