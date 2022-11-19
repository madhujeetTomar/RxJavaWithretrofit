package com.example.rxjavawithretrofit.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rxjavawithretrofit.Product
import com.example.rxjavawithretrofit.model.repository.ProductRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class ProductViewModel(val repository: ProductRepository) : ViewModel() {

    lateinit var disposable: CompositeDisposable
    val productList = MutableLiveData<List<Product>>()
    val _productList : LiveData<List<Product>>
    get() = productList
init {
    disposable =  CompositeDisposable()
    getProductList()
}




    fun getProductList() {

       disposable.add(repository.getProductList().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{products -> productList.value = products})


    }


}