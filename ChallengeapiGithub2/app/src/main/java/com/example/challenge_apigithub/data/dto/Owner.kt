package com.example.challenge_apigithub.data.dto

import com.google.gson.annotations.SerializedName

data class Owner (
    @SerializedName("login")
    val login: String,
    @SerializedName("id")
    val id : Long,
    @SerializedName("node_id")
    val nodeId: String,
    @SerializedName("avatar_url")
    val avatarUrl: String
        )
