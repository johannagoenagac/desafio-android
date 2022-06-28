package com.example.challenge_apigithub.data

class GetRepoRepository (private val getReposRepository: GetRepoRepository) {
    fun getRepo(page: Int, listener: SearchResponseListener){
        this.getReposRepository.getRepo(page, listener)
    }

    fun getPull(owner: String, respository: String, listener: PullResponseListener) {
        this.getReposRepository.getPull(owner, respository, listener)
    }
}