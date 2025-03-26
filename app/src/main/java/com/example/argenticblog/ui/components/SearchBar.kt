package com.example.argenticblog.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun SearchBar(onSearch: (String) -> Unit) {
    var query by remember { mutableStateOf(TextFieldValue("")) }

    OutlinedTextField(
        value = query,
        onValueChange = { query = it },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        placeholder = { Text("Search...") },
        singleLine = true,
        leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "Search Icon") },
        keyboardOptions = KeyboardOptions.Default,
        keyboardActions = KeyboardActions(
            onDone = { onSearch(query.text) }
        )
    )
}
