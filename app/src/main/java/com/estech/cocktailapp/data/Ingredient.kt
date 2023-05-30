package com.estech.cocktailapp.data


import com.squareup.moshi.Json

data class Ingredient(
    @Json(name = "idIngredient")
    val idIngredient: String,
    @Json(name = "strABV")
    val strABV: Any,
    @Json(name = "strAlcohol")
    val strAlcohol: String,
    @Json(name = "strDescription")
    val strDescription: String,
    @Json(name = "strIngredient")
    val strIngredient: String,
    @Json(name = "strType")
    val strType: String
)