package com.aile.android.domain.repository

import com.aile.android.data.local.entity.FlightEntity
import kotlinx.coroutines.flow.Flow

interface FlightRepository {
    fun getAllFlights(): Flow<List<FlightEntity>>
    suspend fun getFlight(flightNumber: String, airlineCode: String): FlightEntity?
    suspend fun insertFlight(flight: FlightEntity)
    // Add more methods for API interaction later
}
