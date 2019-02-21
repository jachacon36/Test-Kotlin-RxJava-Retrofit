package com.example.joker.test_rxjava_retrofit.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.joker.test_rxjava_retrofit.model.adapter.PostAdapter
import com.example.joker.test_rxjava_retrofit.model.api.ApiService
import com.example.joker.test_rxjava_retrofit.model.api.ApiClient
import com.example.joker.test_rxjava_retrofit.model.pojo.Post
import com.example.joker.test_rxjava_retrofit.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    internal lateinit var jsonApi:ApiService
    internal var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Init API

        val retrofit = ApiClient.instance
        jsonApi = retrofit.create(ApiService::class.java)

        //view
        recyclerview.setHasFixedSize(true)
        recyclerview.layoutManager = LinearLayoutManager(this)
        fetchData()

    }

    private fun fetchData() {
        compositeDisposable .add(jsonApi.posts
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe { posts->displayData(posts) })

    }

    private fun displayData(posts: List<Post>?) {
        val adapter = PostAdapter(this,posts!!)
        recyclerview.adapter =adapter

    }

}
