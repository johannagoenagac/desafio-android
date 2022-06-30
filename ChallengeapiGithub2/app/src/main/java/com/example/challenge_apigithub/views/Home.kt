package com.example.challenge_apigithub.views

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.challenge_apigithub.databinding.ActivityHomeBinding


class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private var pageCount = 1

    private val viewModel: HomeViewModel by viewModels(
        factoryProducer = { HomeModelFactory()
        }
    )
    private val homeAdapter = HomeAdapter(object: HomeAdapter.HomeListener {
        override fun repoSelected(owner: String, repository: String) {
            onRepoClickCallPull(owner, repository)
        }
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.idShowRepos.layoutManager = LinearLayoutManager(this)
        binding.idShowRepos.adapter = homeAdapter
        this.title = "Home"
        fillReposInList()

        binding.idShowRepos.addOnScrollListener(object: RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if(dy > 0) {
                        if (!binding.idShowRepos.canScrollVertically(1)) {
                            pageCount++
                            fillReposInList()
                        }
                }
            }
        })
    }

    fun fillReposInList() {
        binding.idPBLoadingHome.isVisible = true
        viewModel.getRepos(pageCount)
        viewModel.repo.observe(this) { value ->
            if (null != value) {
                homeAdapter.setReposItems(value)
               binding.idPBLoadingHome.isVisible = false
            }
        }
    }

    fun onRepoClickCallPull(owner: String, repository: String) {
        val intent = Intent(this, PullList::class.java).apply {
            putExtra("owner", owner)
            putExtra("repository", repository)
        }
        startActivity(intent)
    }


}




