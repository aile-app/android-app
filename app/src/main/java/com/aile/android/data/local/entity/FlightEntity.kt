package com.aile.android.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "flights",
    foreignKeys = [
        ForeignKey(
            entity = AirportEntity::class,
            parentColumns = ["code"],
            childColumns = ["depIata"],
            onDelete = ForeignKey.SET_NULL
        ),
        ForeignKey(
            entity = AirportEntity::class,
            parentColumns = ["code"],
            childColumns = ["arrIata"],
            onDelete = ForeignKey.SET_NULL
        ),
        ForeignKey(
            entity = AirlineEntity::class,
            parentColumns = ["code"],
            childColumns = ["airlineIata"],
            onDelete = ForeignKey.SET_NULL
        )
    ],
    indices = [
        Index("depIata"),
        Index("arrIata"),
        Index("airlineIata")
    ]
)
data class FlightEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val flightNumber: String, // e.g., 123
    val airlineIata: String?, // e.g., DL
    val depIata: String?, // e.g., JFK
    val arrIata: String?, // e.g., LHR
    val depTimeCheckin: Long?, // Check-in time (UTC timestamp)
    val depTimeSch: Long?, // Scheduled departure
    val depTimeEst: Long?, // Estimated departure
    val depTimeAct: Long?, // Actual departure
    val arrTimeSch: Long?, // Scheduled arrival
    val arrTimeEst: Long?, // Estimated arrival
    val arrTimeAct: Long?, // Actual arrival
    val status: String, // scheduled, en-route, landed
    val aircraftIcao: String? = null // e.g., A320
)
