package com.estech.cocktailapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.estech.cocktailapp.adapters.ListaCoctelesViewPagerAdapter
import com.estech.cocktailapp.databinding.ListadosCoctelesInicialFragmentBinding
import com.google.android.material.tabs.TabLayoutMediator

class ListadoCoctelesInicial: Fragment() {

    private lateinit var binding: ListadosCoctelesInicialFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ListadosCoctelesInicialFragmentBinding.inflate(inflater, container, false)
        return (binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewPager.adapter = ListaCoctelesViewPagerAdapter(requireActivity())
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab,position ->
            tab.text = if (position == 0) "Cockteles con Alcohol" else "Cockteles sin Alcohol"
        }.attach()
    }
}