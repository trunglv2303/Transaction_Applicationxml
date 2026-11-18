package com.example.learnxml.Model

data class Transaction(
    val id: Int,
    val amount: Double,
    val type: String,
    val date: String
)