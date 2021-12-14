package com.example.rickandmortyapp.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    private companion object {
        val BASE_URL = "https://rickandmortyapi.com/api/"
    }

    fun retrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun <T> service(retrofit: Retrofit, klass : Class<T>): T {
        return retrofit.create(klass)
    }
}