package com.example.joker.test_rxjava_retrofit.model.api

import com.example.joker.test_rxjava_retrofit.model.pojo.Post
import io.reactivex.Observable
import retrofit2.http.GET


interface ApiService {
    @get: GET ("posts" )
    val posts :Observable<List<Post>>
}