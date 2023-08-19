package com.example.currencyconverter.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.currencyconverter.API.RetrofitHelper
import com.example.currencyconverter.model.CurrencyResponse
import retrofit2.Response

class Repository (private val api : RetrofitHelper) {


    private val mutableResult = MutableLiveData<Double>()
    val liveData: LiveData<Double>
        get() = mutableResult

    suspend fun getRates(from: String , to: String , amount: Double){
        val result = api.apiService.getRates(from , to , amount)

        if (result.body() != null){
            mutableResult.postValue(result.body()!!.result)
        }
    }


}