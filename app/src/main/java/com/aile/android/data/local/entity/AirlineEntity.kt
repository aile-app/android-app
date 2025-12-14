package com.aile.android.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "airlines")
data class AirlineEntity(
    @PrimaryKey val code: String, // IATA code, e.g., DL
    val name: String,
    val logoUrl: String? = null
)
