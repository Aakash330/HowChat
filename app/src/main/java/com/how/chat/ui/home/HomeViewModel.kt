package com.how.chat.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.how.chat.domain.usecase.GetUserUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val getUserUseCase: GetUserUseCase) : ViewModel () {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState


    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.LoadUser -> loadUser()
        }
    }

    private fun loadUser() {
        viewModelScope.launch {
            _uiState.value = HomeUiState(isLoading = true)
            try {
                val user = getUserUseCase()
                _uiState.value = HomeUiState(user = user)
            } catch (e: Exception) {
                _uiState.value = HomeUiState(error = "Failed to load user")
            }
        }
    }
}