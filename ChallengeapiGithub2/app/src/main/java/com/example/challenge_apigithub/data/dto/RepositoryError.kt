package com.example.challenge_apigithub.data.dto

import com.google.gson.annotations.SerializedName
import com.example.challenge_apigithub.data.dto.Error

data class RepositoryError (
    @SerializedName("message")
    val message: String,
    @SerializedName("errors")
    val errors: Error?
        )