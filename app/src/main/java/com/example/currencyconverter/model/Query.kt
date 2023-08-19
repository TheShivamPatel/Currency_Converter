package com.example.currencyconverter.model

data class Query(
    val amount: Double,
    val from: String,
    val to: String
)