package com.example.hotelku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.hotelku.databinding.ActivitySplashScreenBinding

class SplashScreenAct : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding
    private val splashTimeOut: Long = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler().postDelayed({
            val intent = Intent(this@SplashScreenAct, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, splashTimeOut)
    }
}