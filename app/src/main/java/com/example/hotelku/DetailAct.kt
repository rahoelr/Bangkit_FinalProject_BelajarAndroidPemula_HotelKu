package com.example.hotelku

import android.app.Person
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hotelku.databinding.ActivityDetailBinding

class DetailAct : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataHotel = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Hotel>("key_hotel", Hotel::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Hotel>("key_hotel")
        }

        if (dataHotel != null) {
            binding.tvDetail.text = dataHotel.name
            binding.tvDesc.text = dataHotel.description
            binding.imgDetail.setImageResource(dataHotel.photo)
            binding.tvRate.text = dataHotel.rating
        }

        binding.btnPesan.setOnClickListener{
            Toast.makeText(this@DetailAct, "Berhasil Pesan Hotel", Toast.LENGTH_LONG).show()
        }


    }
}