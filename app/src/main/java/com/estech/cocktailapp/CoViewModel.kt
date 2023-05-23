package com.estech.cocktailapp

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.estech.cocktailapp.data.Drink
import com.estech.cocktailapp.data.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CoViewModel(val context: Context): ViewModel() {

    private val repositorio = Repository(context)

    val alcoholLiveData = MutableLiveData<List<Drink>?>()
    val noAlcoholLiveData = MutableLiveData<List<Drink>?>()

    fun getAlcohol() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.getAlcoholic()
            if (response.isSuccessful) {
                val miRespuesta = response.body()
                val listaBebidasAlc = miRespuesta
                alcoholLiveData.postValue(listaBebidasAlc)
            }
        }
    }

    fun getNonAlcohol() {
        CoroutineScope(Dispatchers.IO).launch {
            val response = repositorio.getNonAlcoholic()
            if (response.isSuccessful) {
                val miRespuesta = response.body()
                val listaBebidasNoAlc = miRespuesta
                noAlcoholLiveData.postValue(listaBebidasNoAlc)
            }
        }
    }

    class MyViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(Context::class.java).newInstance(context)
        }
    }


}