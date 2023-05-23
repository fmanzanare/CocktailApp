package com.estech.cocktailapp.data

import android.content.Context
import com.estech.cocktailapp.network.RetrofitHelper

class Repository(val context: Context) {

    private val retrofit = RetrofitHelper.getRetrofit()

    // obtener lista con alcohol
    suspend fun getAlcoholic() = retrofit.alcoholicDrinks()

    // obtener lista sin alcohol

    suspend fun getNonAlcoholic() = retrofit.nonAlcoholicDrinks()

}