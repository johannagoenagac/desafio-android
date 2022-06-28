package com.example.challenge_apigithub.data


import com.example.challenge_apigithub.data.dto.PullResponse
import com.example.challenge_apigithub.data.dto.RepositoryError

interface PullResponseListener {

    fun onPullResponse(response: PullResponse)
    fun onError(repositoryError: RepositoryError)
}