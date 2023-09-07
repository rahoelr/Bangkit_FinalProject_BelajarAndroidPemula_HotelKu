 package com.example.hotelku

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

 class MainActivity : AppCompatActivity() {
    private lateinit var rvHotels: RecyclerView
    private val list = ArrayList<Hotel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHotels = findViewById(R.id.rv_hotels)
        rvHotels.setHasFixedSize(true)

        list.addAll(getListHotels())
        showRecyclerList()
    }

     override fun onCreateOptionsMenu(menu: Menu?): Boolean {
         menuInflater.inflate(R.menu.menu_main, menu)
         return super.onCreateOptionsMenu(menu)
     }

     private fun showRecyclerList() {
         rvHotels.layoutManager = LinearLayoutManager(this)
         val listHotelAdapter = ListHotelAdapter(list)
         rvHotels.adapter = listHotelAdapter

         listHotelAdapter.setOnItemClickCallback(object : ListHotelAdapter.OnItemClickCallback {
             override fun onItemClicked(data: Hotel) {
                 showSelectedHotel(data)
             }

         })
     }

     private fun getListHotels(): ArrayList<Hotel> {
         val dataName = resources.getStringArray(R.array.data_name)
         val dataDescription = resources.getStringArray(R.array.data_description)
         val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
         val dataRating = resources.getStringArray(R.array.data_rating)
         val listHotel = ArrayList<Hotel>()
         for (i in dataName.indices) {
             val hotel = Hotel(
                 name = dataName[i],
                 description = dataDescription[i],
                 photo = dataPhoto.getResourceId(i, -1),
                 rating = dataRating[i]
             )
             listHotel.add(hotel)
         }

         return listHotel
     }

     private fun showSelectedHotel(hotel: Hotel){
         Toast.makeText(this, "Kamu memilih " + hotel.name, Toast.LENGTH_LONG).show()
     }

     override fun onOptionsItemSelected(item: MenuItem): Boolean {
         when (item.itemId){
             R.id.about_page -> {
                 val intentAbout = Intent(this@MainActivity, AboutAct::class.java)
                 startActivity(intentAbout)
             }
         }
         return super.onOptionsItemSelected(item)
     }

 }