package com.example.challenge_apigithub.views

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.challenge_apigithub.data.GetRepoDataSource
import com.example.challenge_apigithub.data.GetRepoRepository


class HomeModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val getReposDatasource = GetRepoDataSource()
        val getReposRepository = GetRepoRepository(getReposDatasource)
        return HomeViewModel(getReposRepository) as T
    }

}