package com.example.challenge_apigithub.data.dto

import com.google.gson.annotations.SerializedName

class PullResponse (
    @SerializedName("state")
    val state: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("body")
    val body: String?,
    @SerializedName("html_url")
    val htmlUrl: String,
    @SerializedName("user")
    val user: User,
    )