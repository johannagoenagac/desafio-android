package com.example.challenge_apigithub.views

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.challenge_apigithub.data.GetRepoRepository
import com.example.challenge_apigithub.data.PullResponseListener
import com.example.challenge_apigithub.data.dto.PullResponse
import com.example.challenge_apigithub.data.dto.RepositoryError


class PullListViewModel (private val repository: GetRepoRepository)
    : ViewModel() {
    val pull = MutableLiveData<List<PullResponse>?>(null)
    val error = MutableLiveData<String?>(null)

    fun getPulls(owner: String, pullRepository: String) {
        pull.value = null
        error.value = null

        repository.getPull(owner, pullRepository, object: PullResponseListener {

            override fun onPullResponse(response: List<PullResponse>?) {
                response.also { pull.value = it }
            }

            override fun onError(repositoryError: RepositoryError) {
                error.value = repositoryError.message
            }

        })
    }
}