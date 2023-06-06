package com.estech.cocktailapp.activities

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.estech.cocktailapp.R
import com.estech.cocktailapp.databinding.ActivityMainBinding
import com.estech.cocktailapp.databinding.CabeceraBinding
import com.estech.cocktailapp.shared_preferences.PrefHelper

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, true)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myPrefHelper = PrefHelper(this)

        val header = binding.navigationView.getHeaderView(0)
        val headerBinding: CabeceraBinding = CabeceraBinding.bind(header)
        if (myPrefHelper.getUsername()?.isNotEmpty() == true)
            headerBinding.tv1.text = myPrefHelper.getUsername()
        else
            headerBinding.tv1.text = "Invitado"
        headerBinding.tv2.text = myPrefHelper.getCurrDate()
        headerBinding.imageView.setImageResource(R.drawable.manhattan)

        navController = findNavController(R.id.fragmentContainerView)

        if (myPrefHelper.getUsername() == "Usuario") {
            appBarConfiguration = AppBarConfiguration(
                setOf(
                    R.id.listadoCoctelesInicial,
                    R.id.detalleCoctelFragment
                ), binding.drawerLayout
            )
            setupActionBarWithNavController(navController, appBarConfiguration)
            binding.navigationView.setupWithNavController(navController)
        } else {
            binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        }
    }
}