package com.estech.cocktailapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.estech.cocktailapp.CoViewModel
import com.estech.cocktailapp.R
import com.estech.cocktailapp.databinding.FragmentNoAlcoholicBinding


class FragmentNoAlcoholic : Fragment() {

    private lateinit var binding: FragmentNoAlcoholicBinding

    private val bebidasNoAlc by activityViewModels<CoViewModel> {
        CoViewModel.MyViewModelFactory(requireContext())
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoAlcoholicBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bebidasNoAlc.getNonAlcohol()


    }
}