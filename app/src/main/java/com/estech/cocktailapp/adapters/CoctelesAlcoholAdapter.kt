package com.estech.cocktailapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.estech.cocktailapp.CoViewModel
import com.estech.cocktailapp.data.Drink
import com.estech.cocktailapp.databinding.CoctelHolderBinding

class CoctelesAlcoholAdapter () : RecyclerView.Adapter<CoctelesAlcoholAdapter.MiCelda>(){

    private var lista = ArrayList<Drink>()

    inner class MiCelda(val binding: CoctelHolderBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiCelda {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = CoctelHolderBinding.inflate(layoutInflater, parent, false)
        return MiCelda(binding)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: MiCelda, position: Int) {
        val info: Drink = lista[position]

        holder.binding.tvCoctelName.text = info.strDrink

        with(holder.binding) {
            Glide.with(
                holder
                    .itemView.context
            )
                .load(info.strDrinkThumb)
                .into(holder.binding.ivCoctelImg)
        }
    }

    fun updateList(list: List<Drink>) {
        lista.clear()
        lista.addAll(list)
        notifyDataSetChanged()
    }
}

