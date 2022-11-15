package com.melichallenge.data.services

import com.google.gson.JsonArray
import retrofit2.Call

class ItemsService() {
    private val apiService = APIService()

    fun searchItems(searchText: String): Call<JsonArray> = apiService.searchItems(searchText)

    fun searchItem(id: String): Call<JsonArray> = apiService.searchItem(id)
}
