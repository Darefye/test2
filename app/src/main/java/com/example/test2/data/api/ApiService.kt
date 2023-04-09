package com.example.test2.data.api

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("/a")
    suspend fun getResponse(): ResponseBody
}