package com.estech.cocktailapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.estech.cocktailapp.CoViewModel
import com.estech.cocktailapp.R
import com.estech.cocktailapp.data.Drink
import com.estech.cocktailapp.databinding.CoctelHolderBinding

class CoctelesAlcoholAdapter(val myViewModel: CoViewModel) :
    RecyclerView.Adapter<CoctelesAlcoholAdapter.MiCelda>() {

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
        val info = lista[position]


        holder.binding.tvCoctelName.text = info.strDrink

        holder.itemView.setOnClickListener {
            myViewModel.chooseDrink(info)
            Navigation.findNavController(it).navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        Glide.with(
            holder.itemView.context)
            .load(info.strDrinkThumb)
            .into(holder.binding.ivCoctelImg)

        holder.itemView.setOnClickListener {
            myViewModel.chooseDrink(info)
        }
    }

    fun updateList(list: List<Drink>?) {
        lista.clear()
        if (list != null) {
            lista.addAll(list)
        }
        notifyDataSetChanged()
    }
}

