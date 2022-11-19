package com.example.rxjavawithretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation

class ProductAdapter() : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    var productList = emptyList<Product>()
    class ProductViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
    {
        val name=itemView.findViewById<TextView>(R.id.txtProductName)
        val description=itemView.findViewById<TextView>(R.id.txtProductDescription)
        val image = itemView.findViewById<ImageView>(R.id.img_product)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_product,parent,false)
        return ProductViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        holder.name.text = productList[position].title
        holder.description.text = productList[position].description
        holder.image.load(productList[position].image) {
            crossfade(true)
        }

    }

    fun updateList(updatedList : List<Product>)
    {
        productList = updatedList
        notifyDataSetChanged()

    }

    override fun getItemCount() = productList.size
}