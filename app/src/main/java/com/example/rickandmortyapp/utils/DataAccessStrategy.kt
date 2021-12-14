package com.example.rickandmortyapp.utils

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import retrofit2.Response

fun <T> performGetOperation(
//    databaseQuery: () -> Flow<T>,
    networkCall: suspend () -> Resource<T>,
//    saveCallResult: suspend (A) -> Unit,
): Flow<Resource<T>> {
    val data: Flow<Resource<T>> =  flow {
        emit(Resource.loading())
//        val source = databaseQuery.invoke().map { Resource.success(it) }
//        emitAll(source)

        val responseStatus: Resource<T> = networkCall.invoke()
        if (responseStatus.status == Resource.Status.SUCCESS) {
            val data: T = responseStatus.data as T
            emit(Resource.success(data))
//            saveCallResult(responseStatus.data!!)

        } else if (responseStatus.status == Resource.Status.ERROR) {
            emit(Resource.error(responseStatus.message!!))
//            emitAll(source)
        }
    }
    return data
}