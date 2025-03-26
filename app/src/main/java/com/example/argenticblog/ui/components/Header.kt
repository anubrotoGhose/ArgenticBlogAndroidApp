package com.example.argenticblog.ui.components


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Header(isLoggedIn: Boolean, onProfileClick: () -> Unit, onLoginClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Welcome to ArgenticBlog", style = MaterialTheme.typography.headlineLarge)
        Text(text = "Share your thoughts with the world", style = MaterialTheme.typography.bodyMedium)

        if (isLoggedIn) {
            Button(onClick = onProfileClick) {
                Text("Profile")
            }
        } else {
            Row {
                Button(onClick = onLoginClick) { Text("Login") }
                Spacer(modifier = Modifier.width(8.dp))
                Button(onClick = onLoginClick) { Text("Sign Up") }
            }
        }
    }
}
