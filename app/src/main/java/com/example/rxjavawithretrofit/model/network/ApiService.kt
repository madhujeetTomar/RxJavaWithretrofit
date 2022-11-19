package com.example.rxjavawithretrofit.model.network

import com.example.rxjavawithretrofit.Product
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("products")
    fun getProductList(): Single<List<Product>>
}