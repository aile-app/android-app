package com.aile.android.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aile.android.data.local.entity.AirportEntity

@Dao
interface AirportDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAirport(airport: AirportEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAirports(airports: List<AirportEntity>)

    @Query("SELECT * FROM airports WHERE code = :code")
    suspend fun getAirport(code: String): AirportEntity?
}
