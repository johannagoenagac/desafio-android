package com.example.challenge_apigithub.data.dto

import com.google.gson.annotations.SerializedName

data class Repository(
    @SerializedName("description")
    val description: Long,
    @SerializedName("id")
    val id: Long,
    @SerializedName("node_id")
    val nodeId: Long,
    @SerializedName("name")
    val name: Long,
    @SerializedName("full_name")
    val fullName: Long,
    @SerializedName("pulls_url")
    val pullsUrl: String,
    @SerializedName("stargazers_count")
    val stargazersCount: Long,
    @SerializedName("forks_count")
    val forksCount: Long,
    @SerializedName("owner")
    val owner: Owner
)