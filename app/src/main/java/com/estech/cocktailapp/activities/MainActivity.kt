package com.estech.cocktailapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.estech.cocktailapp.R
import com.estech.cocktailapp.adapters.ListaCoctelesViewPagerAdapter
import com.estech.cocktailapp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, true)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        binding.viewPager.adapter = ListaCoctelesViewPagerAdapter(this)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab,position ->
            tab.text = if (position == 0) "Cockteles con Alcohol" else "Cockteles sin Alcohol"
        }.attach()

    }
}