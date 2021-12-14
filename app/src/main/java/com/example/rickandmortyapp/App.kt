package com.example.rickandmortyapp

import android.app.Application
import com.example.rickandmortyapp.data.remote.ApiService
import com.example.rickandmortyapp.data.remote.CloudDataSource
import com.example.rickandmortyapp.data.remote.RetrofitInstance
import com.example.rickandmortyapp.data.repository.CharactersRepository
import com.example.rickandmortyapp.domain.usecase.CharactersUseCase
import com.example.rickandmortyapp.ui.home.HomeViewModel

class App : Application() {
    lateinit var homeViewModel : HomeViewModel
    override fun onCreate() {
        super.onCreate()

        val service = RetrofitInstance().retrofit().create(ApiService::class.java)
        val cloudDataSource = CloudDataSource(service)
        val repo = CharactersRepository(cloudDataSource)
        val usecase = CharactersUseCase(repo)
        homeViewModel = HomeViewModel(usecase)
    }
}