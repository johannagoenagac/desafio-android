package com.example.challenge_apigithub.data

import com.example.challenge_apigithub.data.dto.SearchResponse
import com.example.challenge_apigithub.data.dto.RepositoryError

interface SearchResponseListener {

    fun onSearchResponse(response: SearchResponse)
    fun onError(repositoryError: RepositoryError)
}