package com.example.test2.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test2.data.api.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: ApiRepository) : ViewModel() {

    val responseLiveData: MutableLiveData<Int> = MutableLiveData()

    init {
        getResponse()
    }

    private fun getResponse() = viewModelScope.launch {
        val response = repository.getResponse().string()
        response.length.let {
            responseLiveData.postValue(it)
        }
    }
}