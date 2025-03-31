package com.how.chat.ui.home

import com.how.chat.data.model.User

data class HomeUiState(
    val user: User? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)