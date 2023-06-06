package com.estech.cocktailapp

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.estech.cocktailapp.data.Category
import com.estech.cocktailapp.data.Drink
import com.estech.cocktailapp.data.Glasses
import com.estech.cocktailapp.data.Ingredient
import com.estech.cocktailapp.data.Repository
import com.estech.cocktailapp.data.RespuestaCategory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CoViewModel(val context: Context) : ViewModel() {

    private val repositorio = Repository(context)

    val drinksLiveData = MutableLiveData<List<Drink>?>()
    val nonAlcoholicLiveData = MutableLiveData<List<Drink>?>()

    val selectedCoctel = MutableLiveData<Drink>()
    val ingrLiveData = MutableLiveData<List<Ingredient>?>()


    fun getAlcohol(a: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.alcohols(a)
            if (response.isSuccessful) {
                val miRespuesta = response.body()
                if (a == "Alcoholic") {
                    drinksLiveData.postValue(miRespuesta?.drinks)
                } else {
                    nonAlcoholicLiveData.postValue(miRespuesta?.drinks)
                }
            }
        }
    }

    fun getCategory(c: String): MutableLiveData<List<Category>?> {
        val cateLiveData = MutableLiveData<List<Category>?>()
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.category(c)
            if (response.isSuccessful) {
                val miRespuesta = response.body()
                cateLiveData.postValue(miRespuesta?.drinks)
            }
        }
        return cateLiveData
    }

    fun getDrinksByCateg(c: String): MutableLiveData<List<Drink>?> {
        val drinksByCategory = MutableLiveData<List<Drink>?>()
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.getDrinksByCateg(c)
            if (response.isSuccessful) {
                val miRespuesta = response.body()
                drinksByCategory.postValue(miRespuesta?.drinks)
            }
        }
        return drinksByCategory
    }

    fun getIng(i: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.ingredient(i)
            if (response.isSuccessful) {
                val miRespuesta = response.body()
                val listaIng = miRespuesta
                drinksLiveData.postValue(listaIng)
            }
        }
    }

    fun getGlass(g: String): MutableLiveData<List<Glasses>?> {
        val glassesList = MutableLiveData<List<Glasses>?>()
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.glass(g)
            if (response.isSuccessful) {
                val miRespuesta = response.body()
                glassesList.postValue(miRespuesta?.drinks)
            }
        }
        return glassesList
    }

    fun getDrinkByGlass(g: String): MutableLiveData<List<Drink>?>{
        val glassesList2 = MutableLiveData<List<Drink>?>()
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.getDrinksByGlass(g)
            if (response.isSuccessful) {
                val miRespuesta = response.body()
                glassesList2.postValue(miRespuesta?.drinks)
            }
        }
        return glassesList2
    }

    fun getIds(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.ids(id)
            if (response.isSuccessful) {
                val miRespuesta = response.body()
                val listaIds = miRespuesta
                ingrLiveData.postValue(listaIds)
            }
        }
    }

    fun chooseDrink(drink: Drink) {
        selectedCoctel.postValue(drink)
    }


    class MyViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(Context::class.java).newInstance(context)
        }
    }


}