package com.example.argenticblog.ui.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.argenticblog.model.Post
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape

//@Composable
//fun HomeScreen(isLoggedIn: Boolean, posts: List<Post>) {
//    Column(modifier = Modifier.padding(16.dp)) {
//        Text(
//            text = if (isLoggedIn) "Welcome Back!" else "Welcome to Argentic Blog",
//            fontSize = 24.sp,
//            fontWeight = FontWeight.Bold,
//            color = MaterialTheme.colorScheme.primary,
//            modifier = Modifier.padding(bottom = 16.dp)
//        )
//
//        posts.forEach { post ->
//            Card(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(bottom = 12.dp)
//                    .clickable { Log.d("HomeScreen", "Clicked on: ${post.title}") },
//                shape = RoundedCornerShape(8.dp),
//                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
//            ) {
//                Column(modifier = Modifier.padding(16.dp)) {
//                    Text(
//                        text = post.title,
//                        fontSize = 20.sp,
//                        fontWeight = FontWeight.Bold,
//                        color = MaterialTheme.colorScheme.onSurface
//                    )
//                    Text(
//                        text = "By ${post.author}",
//                        fontSize = 14.sp,
//                        color = MaterialTheme.colorScheme.secondary
//                    )
//                    Text(
//                        text = post.date,
//                        fontSize = 12.sp,
//                        color = MaterialTheme.colorScheme.onBackground
//                    )
//                    Spacer(modifier = Modifier.height(8.dp))
//                    Text(
//                        text = post.content,
//                        fontSize = 16.sp,
//                        color = MaterialTheme.colorScheme.onSurface
//                    )
//                }
//            }
//        }
//    }
//}
@Composable
fun HomeScreen(
    isLoggedIn: Boolean,
    posts: List<Post>,
    navigateToDetail: (Post) -> Unit // Function to handle navigation
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), // Single column
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Header item spanning both columns
        item(span = { GridItemSpan(maxLineSpan) }) {
            Text(
                text = if (isLoggedIn) "Welcome Back!" else "Welcome to Argentic Blog",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        // Posts items
        items(posts) { post ->
            PostGridButton(post, navigateToDetail)
        }
    }
}

@Composable
fun PostGridButton(post: Post, navigateToDetail: (Post) -> Unit) {
    Button(
        onClick = { navigateToDetail(post) },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp), // Rounded corners like Card
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = post.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "By ${post.author}",
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.secondary,
                maxLines = 1
            )
            Text(
                text = post.date,
                fontSize = 10.sp,
                color = MaterialTheme.colorScheme.onBackground
            )
            Text(
                text = post.content,
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurface,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
//@Composable
//    fun HomeScreen(
//    isLoggedIn: Boolean,
//    posts: List<Post>,
//    navigateToDetail: (Post) -> Unit
//) {
//        LazyVerticalGrid(
//            columns = GridCells.Fixed(1), // Two columns
//            contentPadding = PaddingValues(16.dp),
//            horizontalArrangement = Arrangement.spacedBy(12.dp),
//            verticalArrangement = Arrangement.spacedBy(12.dp)
//        ) {
//            // Header item spanning both columns
//            item(span = { GridItemSpan(maxLineSpan) }) {
//                Text(
//                    text = if (isLoggedIn) "Welcome Back!" else "Welcome to Argentic Blog",
//                    fontSize = 24.sp,
//                    fontWeight = FontWeight.Bold,
//                    color = MaterialTheme.colorScheme.primary,
//                    modifier = Modifier.padding(bottom = 16.dp)
//                )
//            }
//
//            // Posts items
//            items(posts) { post ->
//                PostGridCard(post)
//            }
//        }
//    }
//
//@Composable
//    fun PostGridCard(post: Post) {
//        Card(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(4.dp)
//                .clickable {
//                    Log.d("HomeScreen", "Clicked on: ${post.title}")
//                },
//            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
//        ) {
//            Column(
//                modifier = Modifier.padding(12.dp),
//                verticalArrangement = Arrangement.spacedBy(8.dp)
//            ) {
//                Text(
//                    text = post.title,
//                    fontSize = 18.sp,
//                    fontWeight = FontWeight.Bold,
//                    color = MaterialTheme.colorScheme.onSurface,
//                    maxLines = 2,
//                    overflow = TextOverflow.Ellipsis
//                )
//                Text(
//                    text = "By ${post.author}",
//                    fontSize = 12.sp,
//                    color = MaterialTheme.colorScheme.secondary,
//                    maxLines = 1
//                )
//                Text(
//                    text = post.date,
//                    fontSize = 10.sp,
//                    color = MaterialTheme.colorScheme.onBackground
//                )
//                Text(
//                    text = post.content,
//                    fontSize = 14.sp,
//                    color = MaterialTheme.colorScheme.onSurface,
//                    maxLines = 3,
//                    overflow = TextOverflow.Ellipsis
//                )
//            }
//        }
//    }
