package com.example.test2.model

data class ApiResponse(
    val endpoints: List<Endpoint>?,
    val group: String?,
    val max_age: Int?
): java.io.Serializable