package com.example.rxjavawithretrofit.model.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    fun getRetrofitInstance() : ApiService {
        return Retrofit.Builder().baseUrl("https://fakestoreapi.com/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create()).build().create(ApiService::class.java)
    }
}