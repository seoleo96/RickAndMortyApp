package com.example.rickandmortyapp.data.remote

import android.util.Log
import com.example.rickandmortyapp.utils.Resource
import retrofit2.Response

abstract class BaseCloudDataSource {
    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Resource<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val data: T? = response.body()
                if (data != null) {
                    Log.d("data", data.toString())
                    return Resource.success(data)
                }
            }
            return error("${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }
    private fun <T> error(message: String): Resource<T> {
        return Resource.error("Network call has failed for a following reason: $message")
    }
}