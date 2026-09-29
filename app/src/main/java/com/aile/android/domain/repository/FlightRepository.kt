package com.aile.android.domain.repository

import com.aile.android.data.local.entity.FlightEntity
import com.aile.android.data.remote.AirLabsFlight
import kotlinx.coroutines.flow.Flow

interface FlightRepository {
    fun getAllFlights(): Flow<List<FlightEntity>>
    suspend fun getFlight(flightNumber: String, airlineCode: String): FlightEntity?
    suspend fun insertFlight(flight: FlightEntity)
    suspend fun searchFlight(flightNumber: String, airlineCode: String): AirLabsFlight?
}