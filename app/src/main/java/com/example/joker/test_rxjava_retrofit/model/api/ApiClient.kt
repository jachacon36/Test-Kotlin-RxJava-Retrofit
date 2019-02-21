package com.example.joker.test_rxjava_retrofit.model.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private var ourInstance: Retrofit?= null

    val instance: Retrofit
        get() {
            if (ourInstance == null){

                ourInstance = Retrofit
                        .Builder()
                        .baseUrl("https://jsonplaceholder.typicode.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build()
            }
            return ourInstance!!
        }
}