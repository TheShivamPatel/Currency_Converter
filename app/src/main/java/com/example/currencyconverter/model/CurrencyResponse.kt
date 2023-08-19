package com.example.currencyconverter.model

data class CurrencyResponse(
    val date: String,
    val historical: Boolean,
    val info: Info,
    val motd: Motd,
    val query: Query,
    val result: Double,
    val success: Boolean
)