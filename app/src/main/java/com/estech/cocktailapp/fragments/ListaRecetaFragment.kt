package com.estech.cocktailapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.estech.cocktailapp.CoViewModel
import com.estech.cocktailapp.databinding.ListaRecetaBinding

class ListaRecetaFragment : Fragment() {

    private lateinit var binding: ListaRecetaBinding
    private val myViewModel by activityViewModels<CoViewModel> {
        CoViewModel.MyViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ListaRecetaBinding.inflate(inflater, container, false)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myViewModel.fullCoctel.observe(viewLifecycleOwner) {
            binding.tvIngredient1.text = it.strIngredient1
            binding.tvMeasure1.text = it.strMeasure1
        }
    }
}