package com.example.challenge_apigithub.views

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challenge_apigithub.data.dto.PullResponse
import com.example.challenge_apigithub.data.utils.PullTranslate
import com.bumptech.glide.Glide
import com.example.challenge_apigithub.databinding.PullItemBinding

class PullListAdapter (private val listener: PullsListActivityListener): RecyclerView.Adapter<PullListAdapter.PullsViewHolder>() {

    private var pulls = ArrayList<PullResponse>()
    interface PullsListActivityListener {
        fun pullSelected(pullLink: String)
    }

    fun setPullsItems(pullsList: List<PullResponse>) {
        this.pulls.addAll(PullTranslate.translatePullToPullItem(pullsList))
        this.notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PullsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = PullItemBinding.inflate(layoutInflater, parent, false)
        return PullsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return this.pulls.size
    }

    override fun onBindViewHolder(holder: PullsViewHolder, position: Int) {
        holder.bind(this.pulls[position])
    }

    inner class PullsViewHolder(private val binding: PullItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(pull: PullResponse) {
            this.binding.idPullTitle.text = pull.title
            this.binding.userName.text = pull.user.login
            this.binding.idPullDescription.text = pull.body
            Glide.with(binding.root).load(pull.user.avatarUrl).into(this.binding.idImgUser)
            this.binding.root.setOnClickListener {
                listener.pullSelected(pull.htmlUrl)
            }
        }
    }
}