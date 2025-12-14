package com.aile.android.di

import android.content.Context
import androidx.room.Room
import com.aile.android.data.local.AileDatabase
import com.aile.android.data.local.dao.AirlineDao
import com.aile.android.data.local.dao.AirportDao
import com.aile.android.data.local.dao.FlightDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AileDatabase {
        return Room.databaseBuilder(
            context,
            AileDatabase::class.java,
            "aile_database"
        ).fallbackToDestructiveMigration() // For development only
         .build()
    }

    @Provides
    fun provideFlightDao(database: AileDatabase): FlightDao {
        return database.flightDao()
    }

    @Provides
    fun provideAirportDao(database: AileDatabase): AirportDao {
        return database.airportDao()
    }

    @Provides
    fun provideAirlineDao(database: AileDatabase): AirlineDao {
        return database.airlineDao()
    }
}
