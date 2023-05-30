package com.estech.cocktailapp.network

import com.estech.cocktailapp.data.Drink
import com.estech.cocktailapp.data.Ingredient
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    // obtener bebidas con alcohol y sin
    @GET("filter.php")
    suspend fun getDrinksAlc(
        @Query("a") a: String
    ): Response<List<Drink>>

    // obtener bebidas por categoría
    @GET("filter.php")
    suspend fun getDrinkCateg(
        @Query("c") c: String
    ): Response<List<Drink>>

    // obtener bebidas por ingrediente
    @GET("filter.php")
    suspend fun getIngredient(
        @Query("i") i: String
    ): Response<List<Drink>>

    // obtener tipo de vaso
    @GET("filter.php")
    suspend fun getTypeGlass(
        @Query("g") g: String
    ): Response<List<Drink>>

    // obtener por id
    @GET("lookup.php")
    suspend fun getById(
        @Query("iid") id: Int
    ): Response<List<Ingredient>>

}