package com.estech.cocktailapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.estech.cocktailapp.R
import com.estech.cocktailapp.activities.MainActivity
import com.estech.cocktailapp.adapters.ListaCoctelesViewPagerAdapter
import com.estech.cocktailapp.databinding.ListadosCoctelesInicialFragmentBinding
import com.estech.cocktailapp.shared_preferences.PrefHelper
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

        val myPrefHelper = PrefHelper(requireContext())

        (requireActivity() as MainActivity).setSupportActionBar(binding.toolbarListaCoctelesInicial)
        if (myPrefHelper.getUsername() == "Usuario") {
            (requireActivity() as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        } else {
            (requireActivity() as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        }
        (requireActivity() as MainActivity).supportActionBar?.setHomeAsUpIndicator(R.drawable.menu_icon)
        (requireActivity() as MainActivity).supportActionBar?.title = "Listado de Cócteles"

        binding.viewPager.adapter = ListaCoctelesViewPagerAdapter(requireActivity())
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab,position ->
            tab.text = if (position == 0) "Cócteles con Alcohol" else "Cócteles sin Alcohol"
        }.attach()
    }
}