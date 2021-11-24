package com.example.countryflag

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.countryflag.network.CountryApi
import kotlinx.coroutines.launch

class OverviewViewModel : ViewModel() {
   var status = MutableLiveData<String>()

    init {
        getFlafPhotos()
    }

    private fun getFlafPhotos() {
        viewModelScope.launch {
            try {
                val listResult = CountryApi.retrofitService.getPhotos()
                status.value = "Success: ${listResult.size} photos retrieved"
            } catch (e: Exception) {
                status.value = "Failure: ${e.message}"
            }
        }
    }
}

