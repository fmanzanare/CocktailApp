package com.estech.cocktailapp.fragments

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.estech.cocktailapp.CoViewModel
import com.estech.cocktailapp.R
import com.estech.cocktailapp.adapters.CoctelesAlcoholAdapter
import com.estech.cocktailapp.data.Category
import com.estech.cocktailapp.databinding.ListaCoctelesBinding
import com.estech.cocktailapp.databinding.ListadoBusquedasBinding

class ListaCategoria : Fragment() {

    private lateinit var binding: ListadoBusquedasBinding
    private lateinit var dialogOptions: Array<String>

    private val myViewModel by activityViewModels<CoViewModel> {
        CoViewModel.MyViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ListadoBusquedasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabSearch.setOnClickListener {

            binding.rvListadoBusqueda.layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)

            val adapter = CoctelesAlcoholAdapter(myViewModel)
            binding.rvListadoBusqueda.adapter = adapter

            myViewModel.getCategory("list").observe(viewLifecycleOwner) {
                if (it != null) {
                    dialogOptions = getName(it)
                }
                val builder = AlertDialog.Builder(requireContext())
                builder.setItems(dialogOptions) { _, position ->
                    myViewModel.getDrinksByCateg(dialogOptions[position]).observe(viewLifecycleOwner) {
                        adapter.updateList(it)
                    }
                }
                builder.create().show()
            }
        }
    }

    fun getName(aList: List<Category>): Array<String> {
        return aList.map { it.strCategory }.toTypedArray()
    }
}