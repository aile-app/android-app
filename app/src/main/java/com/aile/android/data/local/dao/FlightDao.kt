package com.aile.android.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aile.android.data.local.entity.FlightEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FlightDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFlight(flight: FlightEntity)

    @Query("SELECT * FROM flights ORDER BY depTimeSch ASC")
    fun getAllFlights(): Flow<List<FlightEntity>>

    @Query("SELECT * FROM flights WHERE flightNumber = :flightNumber AND airlineIata = :airlineCode")
    suspend fun getFlight(flightNumber: String, airlineCode: String): FlightEntity?
}
