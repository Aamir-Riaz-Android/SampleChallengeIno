package com.example.samplechallengeino.network

import com.example.samplechallengeino.models.requests.LoginRequest
import com.example.samplechallengeino.models.response.ItemsResponse
import com.example.samplechallengeino.models.response.LoginResponse
import com.example.samplechallengeino.utils.Constants
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST(Constants.LOGIN_ENDPOINT)
    suspend fun getLoggedIn(@Body request: LoginRequest): Response<LoginResponse>

    @POST(Constants.ITEMS_DETAILS_END_POINT)
    suspend fun getItemsDetailsList(): Response<ItemsResponse>
}