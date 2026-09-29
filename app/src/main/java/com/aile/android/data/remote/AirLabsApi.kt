package com.aile.android.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface AirLabsApi {
    @GET("flight_status")
    suspend fun getFlightStatus(
        @Query("flight_number") flightNumber: String,
        @Query("airline_code") airlineCode: String,
        @Query("apikey") apiKey: String
    ): AirLabsFlightResponse
}
