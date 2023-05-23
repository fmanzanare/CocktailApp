package com.estech.cocktailapp.activities

import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.estech.cocktailapp.databinding.ActivityLoginBinding
import com.estech.cocktailapp.shared_preferences.PrefHelper

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myPrefHelper = PrefHelper(this)

        val textShader: Shader = LinearGradient(
            0f,
            0f,
            0f,
            200f,
            intArrayOf(Color.rgb(230, 74, 25), Color.YELLOW),
            floatArrayOf(0f, 1f),
            Shader.TileMode.CLAMP
        )
        binding.textView.paint.shader = textShader

        binding.loginButton.setOnClickListener {
            with (binding) {
                // Login Logic to be implemmented!!
            }
        }
    }
}