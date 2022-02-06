package com.example.samplechallengeino.models.response


import com.google.gson.annotations.SerializedName

data class ItemsResponse(
    @SerializedName("itemList")
    val itemList: List<Item>
)