package com.example.hotelku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hotelku.databinding.ActivityAboutBinding

class AboutAct : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fotoAbout.setImageResource(R.drawable.foto_about)
        binding.tvNameAbout.text = "Rahul Rahmatullah"
        binding.tvEmailAbout.text = "rahul.rahmatullah@mail.ugm.ac.id"
    }
}