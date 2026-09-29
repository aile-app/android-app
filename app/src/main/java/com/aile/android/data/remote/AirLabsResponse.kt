package com.aile.android.data.remote

import com.squareup.moshi.Json

data class AirLabsFlightResponse(
    @Json(name = "response") val response: AirLabsFlightResponseData?
)

data class AirLabsFlightResponseData(
    @Json(name = "flight") val flights: List<AirLabsFlight>?
)

data class AirLabsFlight(
    @Json(name = "flight_number") val flightNumber: String,
    @Json(name = "airline_iata") val airlineIata: String?,
    @Json(name = "dep_iata") val depIata: String?,
    @Json(name = "arr_iata") val arrIata: String?,
    @Json(name = "dep_time_utc") val depTimeUtc: String?,
    @Json(name = "arr_time_utc") val arrTimeUtc: String?,
    @Json(name = "status") val status: String?,
    @Json(name = "aircraft_icao") val aircraftIcao: String?
)