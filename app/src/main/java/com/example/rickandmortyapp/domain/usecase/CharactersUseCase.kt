package com.example.rickandmortyapp.domain.usecase

import com.example.rickandmortyapp.data.entities.Character
import com.example.rickandmortyapp.domain.repository.ICharactersRepository
import com.example.rickandmortyapp.utils.Resource
import kotlinx.coroutines.flow.Flow

class CharactersUseCase(
    private val repository: ICharactersRepository
) : ICharactersUseCase {
    override suspend fun fetchCharacters(): Flow<Resource<List<Character>>> {
        return repository.fetchCharacters()
    }
}