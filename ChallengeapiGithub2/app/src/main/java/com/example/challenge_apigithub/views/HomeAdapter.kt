package com.example.challenge_apigithub.views

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.challenge_apigithub.databinding.HomeItemBinding
import com.example.challenge_apigithub.data.dto.Repository
import com.example.challenge_apigithub.data.utils.RepoTranslate
import com.bumptech.glide.Glide


class HomeAdapter (private val listener: HomeListener):
RecyclerView.Adapter<HomeAdapter.HomeViewHolder>(){

    private var repos = ArrayList<Repository>()
    interface HomeListener{
        fun repoSelected(owner: String, repository: String)
    }

    fun setReposItems(newRepoItems: List<Repository>) {
        this.repos.addAll(RepoTranslate.translateRepoToRepository(newRepoItems))
        this.notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = HomeItemBinding.inflate(layoutInflater,parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(this.repos[position])
    }

    override fun getItemCount(): Int {
        return this.repos.size
    }

    inner class HomeViewHolder(
        private val binding: HomeItemBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(repo : Repository) {
            this.binding.hiddenRepoLink.text = repo.pullsUrl
            this.binding.idDescription.text = repo.description
            this.binding.idRepoName.text = repo.name
            this.binding.idFork.text = repo.forksCount.toString()
            this.binding.idStars.text = repo.stargazersCount.toString()
            this.binding.userName.text = repo.owner.login
            Glide.with(binding.root).load(repo.owner.avatarUrl).into(this.binding.idImgUser)
            this.binding.root.setOnClickListener {
                listener.repoSelected(repo.owner.login, repo.name)
            }
            }
        }
    }


