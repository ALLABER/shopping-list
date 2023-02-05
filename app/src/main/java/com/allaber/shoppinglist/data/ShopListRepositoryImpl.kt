package com.allaber.shoppinglist.data

import com.allaber.shoppinglist.domain.ShopItem
import com.allaber.shoppinglist.domain.ShopListRepository

object ShopListRepositoryImpl : ShopListRepository {

    private val shopList = mutableListOf<ShopItem>()
    private var autoIncrementId = 0

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItemById = shopItem.id)
        shopList.remove(oldElement)
        addShopItem(shopItem)
    }

    override fun getShopItem(shopItemById: Int): ShopItem {
        return shopList.find { it.id == shopItemById }
            ?: throw java.lang.RuntimeException("Element witch id $shopItemById not found")
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }

}