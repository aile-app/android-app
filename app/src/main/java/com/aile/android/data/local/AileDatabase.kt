package com.aile.android.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aile.android.data.local.dao.AirlineDao
import com.aile.android.data.local.dao.AirportDao
import com.aile.android.data.local.dao.FlightDao
import com.aile.android.data.local.entity.AirlineEntity
import com.aile.android.data.local.entity.AirportEntity
import com.aile.android.data.local.entity.FlightEntity

@Database(
    entities = [
        FlightEntity::class,
        AirportEntity::class,
        AirlineEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AileDatabase : RoomDatabase() {
    abstract fun flightDao(): FlightDao
    abstract fun airportDao(): AirportDao
    abstract fun airlineDao(): AirlineDao
}
