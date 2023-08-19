package com.example.currencyconverter.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyconverter.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {

//    private val mutableResult = MutableLiveData<Double>()

    val resultLiveData: LiveData<Double>
        get() = repository.liveData

    fun convert(
        amountStr: Double,
        fromCurrency: String,
        toCurrency: String
    ) {

        viewModelScope.launch(Dispatchers.IO) {
            repository.getRates(fromCurrency, toCurrency, amountStr)
        }
    }


}