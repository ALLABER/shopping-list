package com.allaber.shoppinglist.domain

class GetShopItemUseCase(
    private val shopListRepository: ShopListRepository
) {
    fun getShopItemById(shopItemById: Int) : ShopItem {
        return shopListRepository.getShopItemById(shopItemById = shopItemById)
    }
}