package com.example.test2.data.api

import javax.inject.Inject

class ApiRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getResponse() = apiService.getResponse()
}