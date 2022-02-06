package com.example.samplechallengeino.models.requests

import com.google.gson.annotations.SerializedName

data class LoginRequest (
    @SerializedName("username")
    var userName: String,

    @SerializedName("password")
    var password: String
)
