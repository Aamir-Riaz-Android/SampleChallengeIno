package com.example.samplechallengeino.models.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("token")
    var authToken: String,
)
