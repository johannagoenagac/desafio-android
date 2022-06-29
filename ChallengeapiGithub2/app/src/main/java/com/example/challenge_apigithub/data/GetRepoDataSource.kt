package com.example.challenge_apigithub.data

import com.example.challenge_apigithub.data.utils.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.challenge_apigithub.data.dto.PullResponse
import com.example.challenge_apigithub.data.dto.RepositoryError
import com.example.challenge_apigithub.data.dto.SearchResponse


class GetRepoDataSource {

    fun getRepos(page: Int, listener: SearchResponseListener) {
        val service = RetrofitService.instance.create(GetRepoService::class.java).getRepo(page)
        service.enqueue(object: Callback<SearchResponse> {
            override fun onResponse(call: Call<SearchResponse>, response: Response<SearchResponse>) {
                val responseResult = response.body()
                if (response.isSuccessful && null != responseResult) {
                    listener.onSearchResponse(
                        SearchResponse(
                            totalResponse = responseResult.totalResponse,
                            incompleteResults = responseResult.incompleteResults,
                            items = responseResult.items
                        )
                    )
                } else {
                    listener.onError(
                        RepositoryError(
                            message = "Problems reaching destination",
                            errors = null
                        )
                    )
                }
            }

            override fun onFailure(call: Call<SearchResponse>, t: Throwable) {
                listener.onError(
                    RepositoryError(
                        message = t.message ?: "Unexpected error",
                        errors = null
                    )
                )
            }

        })
    }

    /*fun getPulls(owner: String, repository: String, listener: PullResponseListener) {
        val service = RetrofitService.instance.create(GetRepoService::class.java).getPull(owner, repository)

        service.enqueue(object: Callback<PullResponse> {
            override fun onResponse(call: Call<PullResponse>, response: Response<PullResponse>) {
                val responseResult = response.body()
                if (response.isSuccessful && null != responseResult) {
                    listener.onPullResponse(
                       /* PullResponse(
                            state = responseResult.state,
                            title = responseResult.title,
                            body = responseResult.body,
                            user = responseResult.user
                        )*/
                    responseResult
                    )
                } else {
                    listener.onError(
                        RepositoryError(
                            message = "Problems reaching destination",
                            errors = null
                        )
                    )
                }
            }

            override fun onFailure(call: Call<PullResponse>, t: Throwable) {
                listener.onError(
                    RepositoryError(
                        message = t.message ?: "Unexpected error",
                        errors = null
                    )
                )
            }

        })
    }*/

    fun getPulls(owner: String, repository: String, listener: PullResponseListener) {
        val service = RetrofitService.instance.create(GetRepoService::class.java).getPull(owner, repository)

        service.enqueue(object: Callback<List<PullResponse>> {
            override fun onResponse(call: Call<List<PullResponse>>, response: Response<List<PullResponse>>) {
                val responseResult = response.body()
                if (response.isSuccessful && null != responseResult) {
                    listener.onPullResponse(
                        responseResult
                    )
                } else {
                    listener.onError(
                        RepositoryError(
                            message = "Problems reaching destination",
                            errors = null
                        )
                    )
                }
            }

            override fun onFailure(call: Call<List<PullResponse>>, t: Throwable) {
                listener.onError(
                    RepositoryError(
                        message = t.message ?: "Unexpected error",
                        errors = null
                    )
                )
            }

        })
    }
}
