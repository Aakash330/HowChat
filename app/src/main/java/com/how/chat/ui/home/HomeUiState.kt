package com.how.chat.ui.home

data class HomeUiStateval(
    user: User? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)