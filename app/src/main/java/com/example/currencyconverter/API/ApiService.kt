package com.example.currencyconverter.API

import com.example.currencyconverter.model.CurrencyResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/convert")
    suspend fun getRates(
        @Query("from") from: String , @Query("to") to : String , @Query("amount") amount : Double
    ) : Response<CurrencyResponse>



//    https://api.exchangerate.host/convert?from=USD&to=INR&amount=5

}