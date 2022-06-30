package com.example.challenge_apigithub.views

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challenge_apigithub.databinding.ActivityPullBinding

class PullList : AppCompatActivity() {
    private lateinit var binding: ActivityPullBinding
    private lateinit var owner: String
    private lateinit var repository: String
    private val viewModel: PullListViewModel by viewModels(
        factoryProducer = { PullListModelFactory() }
    )

    private val pullsListAdapter = PullListAdapter(object: PullListAdapter.PullsListActivityListener {
        override fun pullSelected(pullLink: String) {
            onPullClickCall(pullLink)
        }
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPullBinding.inflate(layoutInflater)
        setContentView(binding.root)
        owner = intent.extras?.getString("owner").toString()
        repository = intent.extras?.getString("repository").toString()
        this.title = repository
        binding.idShowPull.layoutManager = LinearLayoutManager(this)
        binding.idShowPull.adapter = pullsListAdapter
        fillPullsInList()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    private fun fillPullsInList() {
        binding.idPBLoading.isVisible = true
        viewModel.getPulls(owner, repository)
        viewModel.pull.observe(this) {
                value ->
            if(null != value) {
                pullsListAdapter.setPullsItems(value)
                binding.idPBLoading.isVisible = false
            }
        }
    }

    fun onPullClickCall(pullLink: String) {
        val intent = Intent(Intent.ACTION_VIEW).setData(Uri.parse(pullLink))
        startActivity(intent)
    }
}