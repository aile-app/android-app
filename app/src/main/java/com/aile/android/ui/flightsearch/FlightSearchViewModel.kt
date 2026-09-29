package com.aile.android.ui.flightsearch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aile.android.data.local.entity.FlightEntity
import com.aile.android.data.remote.AirLabsFlight
import com.aile.android.domain.repository.FlightRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class FlightSearchUiState(
    val query: String = "",
    val searchResults: List<FlightEntity> = emptyList(),
    val airLabsResult: AirLabsFlight? = null,
    val isLoading: Boolean = false
)

@HiltViewModel
class FlightSearchViewModel @Inject constructor(
    private val flightRepository: FlightRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(FlightSearchUiState())
    val uiState: StateFlow<FlightSearchUiState> = _uiState.asStateFlow()

    fun onQueryChanged(newQuery: String) {
        _uiState.update { it.copy(query = newQuery) }
    }

    fun onSearchTriggered() {
        val query = _uiState.value.query
        if (query.isEmpty()) return
        _uiState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            val result = flightRepository.searchFlight(query, "AA")
            _uiState.update { it.copy(
                airLabsResult = result,
                isLoading = false
            ) }
        }
    }
}