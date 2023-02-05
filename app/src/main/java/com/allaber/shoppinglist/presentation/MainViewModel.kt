package com.allaber.shoppinglist.presentation

import androidx.lifecycle.ViewModel
import com.allaber.shoppinglist.data.ShopListRepositoryImpl
import com.allaber.shoppinglist.domain.DeleteShopItemUseCase
import com.allaber.shoppinglist.domain.EditShopItemUseCase
import com.allaber.shoppinglist.domain.GetShopListUseCase
import com.allaber.shoppinglist.domain.ShopItem

class MainViewModel : ViewModel() {
    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    var shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem = shopItem)
    }

    fun changeEnabledState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }

}