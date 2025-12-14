package com.aile.android.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aile.android.data.local.entity.AirlineEntity

@Dao
interface AirlineDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAirline(airline: AirlineEntity)

    @Query("SELECT * FROM airlines WHERE code = :code")
    suspend fun getAirline(code: String): AirlineEntity?
}
