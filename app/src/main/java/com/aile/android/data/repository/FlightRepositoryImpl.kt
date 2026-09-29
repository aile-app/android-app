package com.aile.android.data.repository

import com.aile.android.data.local.dao.FlightDao
import com.aile.android.data.local.entity.FlightEntity
import com.aile.android.data.remote.AirLabsApi
import com.aile.android.domain.repository.FlightRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FlightRepositoryImpl @Inject constructor(
    private val flightDao: FlightDao,
    private val airLabsApi: AirLabsApi
) : FlightRepository {

    override fun getAllFlights(): Flow<List<FlightEntity>> {
        return flightDao.getAllFlights()
    }

    override suspend fun getFlight(flightNumber: String, airlineCode: String): FlightEntity? {
        return flightDao.getFlight(flightNumber, airlineCode)
    }

    override suspend fun insertFlight(flight: FlightEntity) {
        flightDao.insertFlight(flight)
    }

    override suspend fun searchFlight(flightNumber: String, airlineCode: String): AirLabsFlight? {
        return try {
            val response = airLabsApi.getFlightStatus(flightNumber, airlineCode, "demo_key")
            response.response?.flights?.firstOrNull()
        } catch (e: Exception) {
            null
        }
    }
}
