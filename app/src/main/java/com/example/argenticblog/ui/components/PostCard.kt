package com.example.argenticblog.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.argenticblog.model.Post

@Composable
fun PostCard(post: Post, onClick: (String) -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        shape = RoundedCornerShape(12.dp),
        onClick = { onClick(post.articleId) }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = post.title, style = MaterialTheme.typography.titleLarge)
            Text(text = "Posted by ${post.username} on ${post.timestamp}", style = MaterialTheme.typography.labelMedium)
            Text(
                text = post.content.take(200) + if (post.content.length > 200) "..." else "",
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
