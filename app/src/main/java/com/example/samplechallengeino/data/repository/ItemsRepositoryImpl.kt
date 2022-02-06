package com.example.samplechallengeino.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.samplechallengeino.data.*
import com.example.samplechallengeino.data.parsing.ContentState
import com.example.samplechallengeino.data.parsing.ErrorState
import com.example.samplechallengeino.data.parsing.LoadingState
import com.example.samplechallengeino.data.parsing.UiState
import com.example.samplechallengeino.models.requests.LoginRequest
import com.example.samplechallengeino.models.response.ItemsResponse
import com.example.samplechallengeino.network.ApiService
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class ItemsRepositoryImpl @Inject constructor(private val apiService: ApiService, private val sessionManager: SessionManager) {

    private val _uiState by lazy {
        MutableLiveData<UiState>()
    }
    private val _itemDetails by lazy {
        MutableLiveData<ItemsResponse>()
    }

    fun getUiUpdates(): LiveData<UiState> = _uiState
    fun getItemDetailsUpdates(): LiveData<ItemsResponse> = _itemDetails

    suspend fun loggedInUser(){
        _uiState.postValue(LoadingState)
        coroutineScope {
            val response=apiService.getLoggedIn(LoginRequest("test1","123"))
            if(response.isSuccessful){
                response.body()?.let {
                    _uiState.postValue(ContentState)
                    sessionManager.saveAuthToken(it.authToken)
                }
            }
        }
    }

    suspend fun getItemsDetails() {
        _uiState.postValue(LoadingState)
        coroutineScope {
            val response = apiService.getItemsDetailsList()
            if (response.isSuccessful) {
                response.body()?.let {
                    _uiState.postValue(ContentState)
                    _itemDetails.postValue(it)

                }

            } else {
                _uiState.postValue(ErrorState)
            }

        }


    }

}
