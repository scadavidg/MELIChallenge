package com.melichallenge.domain.usecases

import com.melichallenge.domain.repositories.ItemsRepository

class SearchItemsUseCase(private val itemsRepository: ItemsRepository) {
    suspend operator fun invoke(searchText: String) = itemsRepository.searchItems(searchText)
}
