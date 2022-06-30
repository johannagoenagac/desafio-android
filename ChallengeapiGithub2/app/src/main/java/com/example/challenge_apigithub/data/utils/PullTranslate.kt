package com.example.challenge_apigithub.data.utils

import com.example.challenge_apigithub.data.dto.PullResponse


object PullTranslate {
    fun translatePullsToPullsItem(pullsList: List<PullResponse>): ArrayList<PullResponse> {
        val pullsItemList = ArrayList<PullResponse>()
        pullsList.forEach {
            pullsItemList.add(
                PullResponse(it.state,
                    it.title,
                    it.body,
                    it.htmlUrl,
                    it.user)
            )
        }
        return pullsItemList
    }
}
