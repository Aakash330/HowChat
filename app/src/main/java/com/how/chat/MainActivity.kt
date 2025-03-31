package com.how.chat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.how.chat.ui.home.HomeScreen
import com.how.chat.ui.theme.ChatAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()
        setContent {
            ChatAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   LoginScreen()
                }
            }
        }
    }
}

@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Image at the top
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground), // Replace with your image
            contentDescription = "Logo",
            modifier = Modifier.size(128.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Username TextField
        TextField(
            value = TextFieldValue(""),
            onValueChange = {},
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(16.dp)),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Password TextField
        TextField(
            value = TextFieldValue(""),
            onValueChange = {},
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(12.dp)),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            textStyle = TextStyle.Default
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Login Button
        Button(
            onClick = { /* Handle Login */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Login")
        }
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ChatAppTheme {
        LoginScreen()
    }
}