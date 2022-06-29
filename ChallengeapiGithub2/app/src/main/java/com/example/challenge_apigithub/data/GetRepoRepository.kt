package com.example.challenge_apigithub.data

import com.example.challenge_apigithub.data.dto.PullResponse
import com.example.challenge_apigithub.data.PullResponseListener


class GetRepoRepository (private val getRepoDataSource: GetRepoDataSource) {

    fun getRepo(page: Int, listener: SearchResponseListener){
        this.getRepoDataSource.getRepos(page, listener)
    }

    fun getPull(owner: String, repository: String, listener: PullResponseListener) {
        this.getRepoDataSource.getPulls(owner, repository, listener)
    }
}