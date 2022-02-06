package com.example.samplechallengeino.models.response


import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("itemRate")
    val itemRate: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Double
)