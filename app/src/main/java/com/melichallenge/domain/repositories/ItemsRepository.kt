package com.melichallenge.domain.repositories

import com.melichallenge.data.models.Result
import com.melichallenge.domain.models.ItemDetail
import com.melichallenge.domain.models.ItemList

interface ItemsRepository {

    suspend fun searchItems(searchText: String): Result<List<ItemList>>

    suspend fun searchItem(id: String): Result<ItemDetail>
}
