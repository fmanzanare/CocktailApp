package com.estech.cocktailapp.data


import com.squareup.moshi.Json

data class Drink(
    @Json(name = "idDrink")
    val idDrink: String,
    @Json(name = "strDrink")
    val strDrink: String,
    @Json(name = "strDrinkThumb")
    val strDrinkThumb: String
)