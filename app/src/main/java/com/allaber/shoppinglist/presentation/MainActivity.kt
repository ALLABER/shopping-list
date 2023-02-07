package com.allaber.shoppinglist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.allaber.shoppinglist.R
import com.allaber.shoppinglist.presentation.ShopListAdapter.Companion.MAX_PULL_SIZE
import com.allaber.shoppinglist.presentation.ShopListAdapter.Companion.VIEW_TYPE_DISABLED
import com.allaber.shoppinglist.presentation.ShopListAdapter.Companion.VIEW_TYPE_ENABLED

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: ShopListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.shopList.observe(this) {
            adapter.shopList = it
        }
    }

    private fun setupRecyclerView() {
        val rvShopList = findViewById<RecyclerView>(R.id.rv_shop_list)
        adapter = ShopListAdapter()

        with(rvShopList) {
            adapter = adapter
            recycledViewPool.setMaxRecycledViews(VIEW_TYPE_DISABLED, MAX_PULL_SIZE)
            recycledViewPool.setMaxRecycledViews(VIEW_TYPE_ENABLED, MAX_PULL_SIZE)
        }

    }
}