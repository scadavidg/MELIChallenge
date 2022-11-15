package com.melichallenge.data.mapper

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.melichallenge.domain.models.ItemDetail

object ItemDetailMap {
    fun map(json: JsonElement): ItemDetail {
        with(json as JsonObject) {
            return ItemDetail(
                id = get("id").toString(),
                title = get("title").toString(),
                thumbnail = get("thumbnail").toString(),
                price = get("price").toString(),
                currency = get("currency_id").toString(),
                freShipping = getAsJsonObject("shipping").get("free_shipping").asBoolean,
                condition = ItemListMap.getItemCondition(get("condition").toString())
            )
        }
    }
}
