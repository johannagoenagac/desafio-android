package com.example.challenge_apigithub.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.challenge_apigithub.R
import com.example.challenge_apigithub.databinding.ActivityHomeBinding
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private var pageCount = 1

    private val viewModel: HomeViewModel by viewModels(
        factoryProducer = { HomeModelFactory()
        }
    )

    private val homeAdapter = HomeAdapter(object: HomeAdapter.HomeListener {
        override fun repoSelected(repoLink: String) {
            onRepoClickCallPull(repoLink)
        }
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.idShowRepos.layoutManager = LinearLayoutManager(this)
        binding.idShowRepos.adapter = homeAdapter
        viewModel.getRepos(pageCount)
        viewModel.repo.observe(this) { value ->
            if (null != value) {
                homeAdapter.setReposItems(value)
            }
        }

            binding.idShowRepos.addOnScrollListener(object: RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if(dy > 0) {
                    if(!binding.idShowRepos.canScrollVertically(1)) {
                        pageCount++

                    }
                }
            }
        })
    }

    
    fun onRepoClickCallPull(pullsLink: String) {
        Toast.makeText(this, "List item clicked!!!", Toast.LENGTH_LONG).show()
    }
}


