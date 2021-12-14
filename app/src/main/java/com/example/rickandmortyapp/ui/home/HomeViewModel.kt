package com.example.rickandmortyapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyapp.data.entities.Character
import com.example.rickandmortyapp.domain.usecase.CharactersUseCase
import com.example.rickandmortyapp.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class HomeViewModel(
    private val charactersUseCase: CharactersUseCase,
) : ViewModel() {

    private val _characters: MutableLiveData<Resource<List<Character>>> =
        MutableLiveData(Resource.loading())
    val characters: LiveData<Resource<List<Character>>> = _characters

    init {
        viewModelScope.launch{
            charactersUseCase.fetchCharacters()
                .collect {
                    _characters.value = it
                }
        }
    }
}