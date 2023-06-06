package com.estech.cocktailapp.network

import com.estech.cocktailapp.data.Category
import com.estech.cocktailapp.data.Drink
import com.estech.cocktailapp.data.Ingredient
import com.estech.cocktailapp.data.Respuesta
import com.estech.cocktailapp.data.RespuestaCategory
import com.estech.cocktailapp.data.RespuestaIngrediente
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    // obtener bebidas con alcohol y sin
    @GET("filter.php")
    suspend fun getDrinksAlc(
        @Query("a") a: String
    ): Response<Respuesta>

    // obtener bebidas por categoría
    @GET("list.php")
    suspend fun getDrinkCateg(
        @Query("c") c: String
    ): Response<RespuestaCategory>

    @GET("filter.php")
    suspend fun getDrinksByCateg(
        @Query("c") c: String
    ): Response<Respuesta>

    // obtener bebidas por ingrediente
    @GET("list.php")
    suspend fun getIngredient(
        @Query("i") i: String
    ): Response<RespuestaIngrediente>

    @GET("list.php")
    suspend fun getDrinksByIng(
        @Query("i") i: String
    ): Response<Respuesta>

    // obtener tipo de vaso
    @GET("list.php")
    suspend fun getTypeGlass(
        @Query("g") g: String
    ): Response<List<Drink>>

    // obtener por id
    @GET("lookup.php")
    suspend fun getById(
        @Query("iid") id: Int
    ): Response<List<Ingredient>>

}