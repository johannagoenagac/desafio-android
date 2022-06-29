package com.example.challenge_apigithub.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import com.example.challenge_apigithub.data.dto.PullResponse
import com.example.challenge_apigithub.data.dto.SearchResponse


interface GetRepoService {

    @GET("search/repositories?q=language:Java&sort=stars")
    fun getRepo(@Query("page") page: Int): Call<SearchResponse>

    @GET("repos/{owner}/{repository}/pulls")
    fun getPull(@Path("owner") owner: String, @Path("repository") repository: String): Call<List<PullResponse>>

}