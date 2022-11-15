package com.melichallenge.domain.usecases

import com.melichallenge.domain.repositories.ItemsRepository

class SearchItemUseCase(private val itemsRepository: ItemsRepository) {
    suspend operator fun invoke(id: String) = itemsRepository.searchItem(id)
}
