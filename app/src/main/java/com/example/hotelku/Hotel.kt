package com.example.hotelku

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hotel(
    val name: String,
    val description: String,
    val photo: Int,
    val rating: String
) :Parcelable
