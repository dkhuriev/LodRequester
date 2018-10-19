package com.example.macbook.android_beta.models

import java.io.Serializable

data class RequestModel (
        val name: String,
        val description: String,
        val dormName: String,
        val tags: List<String>,
        val price: String
) : Serializable
