package com.example.rxjavawithretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rxjavawithretrofit.model.network.RetrofitInstance
import com.example.rxjavawithretrofit.model.repository.ProductRepository
import com.example.rxjavawithretrofit.view.viewmodel.ProductViewModel

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    lateinit var viewModel: ProductViewModel
    private lateinit var repository: ProductRepository
    private lateinit var adapter: ProductAdapter
    private lateinit var recyclerview: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = ProductAdapter()
        recyclerview = findViewById(R.id.recyProduct)
        setupRecyclerView()
        repository = ProductRepository(RetrofitInstance.getRetrofitInstance())
        viewModel = ProductViewModel(repository)

        viewModel.productList.observe(this, { product -> getProductList(product) })

    }

    fun getProductList(product: List<Product>) {
        Log.d("TAG", "getProductList: " + product.size)
        adapter.updateList(product)
    }

    private fun setupRecyclerView() {

        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(this)
    }
}
