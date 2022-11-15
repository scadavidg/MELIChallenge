package com.melichallenge.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlin.random.Random

@Parcelize
data class ItemList(
    val id: String,
    val title: String,
    val thumbnail: String,
    val price: String,
    val currency: String,
    val condition: ItemConditionType,
    var freShipping: Boolean = Random.nextBoolean()
) : Parcelable

@Parcelize
data class ItemDetail(
    val id: String,
    val title: String,
    val thumbnail: String,
    val price: String,
    val currency: String,
    val condition: ItemConditionType,
    var freShipping: Boolean = Random.nextBoolean()
) : Parcelable

enum class ItemConditionType {
    USED,
    NEW,
    OTHER
}
