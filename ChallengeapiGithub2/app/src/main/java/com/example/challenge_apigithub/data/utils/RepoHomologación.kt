package com.example.challenge_apigithub.data.utils

import com.example.challenge_apigithub.data.dto.Repository

object RepoHomologación {

        fun homologarRepoToRepository(repoList: List<Repository>): ArrayList<Repository> {
            val repoItemList = ArrayList<Repository>()
            repoList.forEach {
                repoItemList.add(
                    Repository(it.id,
                        it.nodeId,
                        it.name,
                        it.fullName,
                        it.description,
                        it.pullsUrl,
                        it.stargazersCount,
                        it.forksCount,
                        it.owner)
                )
            }
            return repoItemList
        }
    }
