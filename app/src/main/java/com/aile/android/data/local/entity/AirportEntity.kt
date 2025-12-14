package com.aile.android.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "airports")
data class AirportEntity(
    @PrimaryKey val code: String, // IATA code, e.g., JFK
    val name: String,
    val city: String,
    val countryCode: String,
    val latitude: Double,
    val longitude: Double,
    val timezone: String
)
