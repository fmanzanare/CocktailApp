package com.estech.cocktailapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.estech.cocktailapp.CoViewModel
import com.estech.cocktailapp.activities.MainActivity
import com.estech.cocktailapp.databinding.DetalleCoctelBinding

class RandomCoctelFragment : Fragment() {

    private lateinit var binding: DetalleCoctelBinding

    private val myViewModel by activityViewModels<CoViewModel> {
        CoViewModel.MyViewModelFactory(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DetalleCoctelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (requireActivity() as MainActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

        myViewModel.getRandomCoctel().observe(viewLifecycleOwner) {
            (requireActivity() as MainActivity).supportActionBar?.title = it?.get(0)?.strDrink
            Glide.with(this)
                .load(it?.get(0)?.strDrinkThumb)
                .into(binding.ivCatImage)
            it?.get(0)?.let { it1 -> myViewModel.putFullCoctel(it1) }
        }
    }
}