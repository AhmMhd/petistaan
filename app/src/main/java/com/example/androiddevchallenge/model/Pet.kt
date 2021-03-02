package com.example.androiddevchallenge.model

import androidx.annotation.IntegerRes

data class Pet(
    var name: String,
    var averageSize: String,
    var lifeExpectancy: String,
    var age: String,
    @IntegerRes var avatar : Int
)

