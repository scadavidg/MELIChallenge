package com.melichallenge.data.repositories

import com.google.gson.JsonArray
import com.melichallenge.data.mapper.ItemDetailMap
import com.melichallenge.data.mapper.ItemListMap
import com.melichallenge.data.models.Result
import com.melichallenge.data.services.ItemsService
import com.melichallenge.domain.models.ItemDetail
import com.melichallenge.domain.models.ItemList
import com.melichallenge.domain.repositories.ItemsRepository
import com.melichallenge.utils.handleResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class ItemsRepositoryImpl(private val itemsService: ItemsService) : ItemsRepository {

    override suspend fun searchItems(searchText: String): Result<List<ItemList>> = suspendCoroutine { coroutine ->
        val call = itemsService.searchItems(searchText)
        call.enqueue(object : Callback<JsonArray> {
            override fun onResponse(call: Call<JsonArray>, response: Response<JsonArray>) {
                response.handleResponse(
                    continuation = coroutine,
                    transformation = { jsonArray ->
                        jsonArray.map { ItemListMap.map(it) }
                    }
                )
            }

            override fun onFailure(call: Call<JsonArray>, t: Throwable) {
                coroutine.resume(Result.failure<Exception>(t.fillInStackTrace()))
            }
        })
    }

    override suspend fun searchItem(id: String): Result<ItemDetail> = suspendCoroutine { coroutine ->
        val call = itemsService.searchItem(id)
        call.enqueue(object : Callback<JsonArray> {
            override fun onResponse(call: Call<JsonArray>, response: Response<JsonArray>) {
                response.handleResponse(
                    continuation = coroutine,
                    transformation = {
                        ItemDetailMap.map(it.first())
                    }
                )
            }

            override fun onFailure(call: Call<JsonArray>, t: Throwable) {
                coroutine.resume(Result.failure<Exception>(t.fillInStackTrace()))
            }
        })
    }
}
