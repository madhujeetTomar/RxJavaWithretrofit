package com.example.rxjavawithretrofit.model.repository

import com.example.rxjavawithretrofit.Product
import com.example.rxjavawithretrofit.model.network.ApiService

class ProductRepository(val apiService: ApiService) {

    fun getProductList() = apiService.getProductList()

}