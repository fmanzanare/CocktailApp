package com.estech.cocktailapp.data

import android.content.Context
import com.estech.cocktailapp.network.RetrofitHelper

class Repository(val context: Context) {

    private val retrofit = RetrofitHelper.getRetrofit()

    // para obtener según tenga alcohol o no
    suspend fun alcohols(a: String) = retrofit.getDrinksAlc(a)

    // para obtener según la categoría
    suspend fun category(c: String) = retrofit.getDrinkCateg(c)

    // para obtener según el ingrediente
    suspend fun ingredient(i: String) = retrofit.getIngredient(i)

    // para obtener según el vaso
    suspend fun glass(g: String) = retrofit.getTypeGlass(g)

    // para obtener por id
    suspend fun ids(id: Int) = retrofit.getById(id)


}