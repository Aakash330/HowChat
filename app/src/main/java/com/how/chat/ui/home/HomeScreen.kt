package com.how.chat.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(viewModel: HomeViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        when {
            uiState.isLoading -> CircularProgressIndicator()
            uiState.error != null -> Text("Error: ${uiState.error}")
            uiState.user != null -> Text("Welcome, ${uiState.user!!.name}!")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { viewModel.onEvent(HomeEvent.LoadUser) }) {
            Text("Load User")
        }
    }
}