package com.allaber.shoppinglist.domain

class GetShopItemUseCase(
    private val shopListRepository: ShopListRepository
) {
    fun getShopItem(shopItemById: Int) : ShopItem {
        return shopListRepository.getShopItem(shopItemById = shopItemById)
    }
}