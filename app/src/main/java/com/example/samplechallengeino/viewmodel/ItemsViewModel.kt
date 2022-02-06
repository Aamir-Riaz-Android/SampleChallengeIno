package com.example.samplechallengeino.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.samplechallengeino.data.parsing.UiState
import com.example.samplechallengeino.data.repository.ItemsRepositoryImpl
import com.example.samplechallengeino.models.response.ItemsResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemsViewModel @Inject constructor(private val itemsRepositoryImpl: ItemsRepositoryImpl) :
    ViewModel() {
    val _uiState: LiveData<UiState> = itemsRepositoryImpl.getUiUpdates()
    val _itemDetailsList: LiveData<ItemsResponse> = itemsRepositoryImpl.getItemDetailsUpdates()

    fun getLoggedin(){
        viewModelScope.launch {
            itemsRepositoryImpl.loggedInUser()
        }
    }
    fun getDataFromRemoteSource() {
        viewModelScope.launch {
            itemsRepositoryImpl.getItemsDetails()
        }
    }


}