package com.example.sampleflowkotlin

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.BeerRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


class MainViewModel @ViewModelInject constructor(private val beerRepository: BeerRepository): ViewModel(){
    //private val _postStateFlow : MutableStateFlow<>

    fun getBeerList() = viewModelScope.launch {
        Log.d("debug555",beerRepository.getBeerList().toString())
    }
}
