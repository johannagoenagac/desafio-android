package com.example.challenge_apigithub.views


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.challenge_apigithub.data.GetRepoRepository
import com.example.challenge_apigithub.data.SearchResponseListener
import com.example.challenge_apigithub.data.dto.Repository
import com.example.challenge_apigithub.data.dto.RepositoryError
import com.example.challenge_apigithub.data.dto.SearchResponse



class HomeViewModel(private val repository: GetRepoRepository)
    : ViewModel(){

        val repo = MutableLiveData<List<Repository>?>(null)
        val error = MutableLiveData<String?>(null)


    fun getRepos(page: Int) {
        repo.value = null
        error.value = null

        repository.getRepo(page, object: SearchResponseListener {
            override fun onSearchResponse(response: SearchResponse) {
                repo.value = response.items
            }

            override fun onError(repositoryError: RepositoryError) {
                error.value = repositoryError.message
            }

        })
    }


}