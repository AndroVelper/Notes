package com.shubham.notes.utils

sealed class ResponseManager<T> {
    data class OnError<T>(val data: T) : ResponseManager<T>()
    data class OnSuccess<T>(val data: T) : ResponseManager<T>()
    data class IsLoading(val isLoading: Boolean) : ResponseManager<Nothing>()
    data class OnServerError<T>(val code: Int, val message: String) : ResponseManager<T>()
    data class OnNetworkError<T>(val message: String) : ResponseManager<T>()
}

