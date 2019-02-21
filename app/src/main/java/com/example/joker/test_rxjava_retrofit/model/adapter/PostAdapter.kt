package com.example.joker.test_rxjava_retrofit.model.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.joker.test_rxjava_retrofit.model.pojo.Post
import com.example.joker.test_rxjava_retrofit.R
import kotlinx.android.synthetic.main.post_item.view.*

class PostAdapter(internal var context:Context, internal var postList: List<Post>):RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): PostViewHolder {
        val itemView= LayoutInflater.from(p0.context)
                .inflate(R.layout.post_item,p0,false)
        return PostViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(p0: PostViewHolder, p1: Int) {
        p0.txt_author.text=postList.get(p1).userId.toString()
        p0.txt_title.text=postList.get(p1).title
        p0.txt_content.text= StringBuilder(postList.get(p1).body.substring(0,20)).append("...")
    }


    class PostViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val txt_author = itemView.txt_author
        val txt_title = itemView.txt_tittle
        val txt_content= itemView.txt_content

    }
}