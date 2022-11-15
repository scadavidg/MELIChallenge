package com.melichallenge.data.mapper

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.melichallenge.domain.models.ItemConditionType
import com.melichallenge.domain.models.ItemConditionType.NEW
import com.melichallenge.domain.models.ItemConditionType.OTHER
import com.melichallenge.domain.models.ItemConditionType.USED
import com.melichallenge.domain.models.ItemList

object ItemListMap {
    fun map(json: JsonElement): ItemList {
        with(json as JsonObject) {
            return ItemList(
                id = get("id").toString(),
                title = get("title").toString(),
                thumbnail = get("thumbnail").toString(),
                price = get("price").toString(),
                currency = get("currency_id").toString(),
                freShipping = getAsJsonObject("shipping").get("free_shipping").asBoolean,
                condition = getItemCondition(get("condition").toString())
            )
        }
    }

    fun getItemCondition(rawString: String): ItemConditionType {
        return if (rawString === "used") USED
        else if (rawString === "new") NEW
        else OTHER
    }
}
