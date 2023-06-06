package com.estech.cocktailapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.estech.cocktailapp.CoViewModel
import com.estech.cocktailapp.databinding.DescriptionCoctelBinding

class DescripcionCoctelFragment : Fragment() {

    private lateinit var binding: DescriptionCoctelBinding

    private val myViewModel by activityViewModels<CoViewModel> {
        CoViewModel.MyViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DescriptionCoctelBinding.inflate(inflater, container, false)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myViewModel.fullCoctel.observe(viewLifecycleOwner) {
            binding.tvMeasure1

            it.strCategory

            if (!it.strIBA.isNullOrEmpty()) {
                binding.lifespan.text = it.strIBA
            } else {
                binding.tvIngredient4.visibility = View.GONE
                binding.lifespan.visibility = View.GONE
            }

        }
    }
}