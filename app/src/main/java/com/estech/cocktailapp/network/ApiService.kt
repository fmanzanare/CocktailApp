package com.estech.cocktailapp.network

import com.estech.cocktailapp.data.Drink
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    // obtener bebidas alcohólicas
    @GET("filter.php?a=Alcoholic")
    suspend fun alcoholicDrinks(): Response<List<Drink>>

    // obtener bebidas no alcohólicas
    @GET("filter.php?a=Non_Alcoholic")
    suspend fun nonAlcoholicDrinks(): Response<List<Drink>>

}