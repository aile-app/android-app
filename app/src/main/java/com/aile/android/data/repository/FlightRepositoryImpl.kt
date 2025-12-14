package com.aile.android.data.repository

import com.aile.android.data.local.dao.FlightDao
import com.aile.android.data.local.entity.FlightEntity
import com.aile.android.domain.repository.FlightRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FlightRepositoryImpl @Inject constructor(
    private val flightDao: FlightDao
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
}
