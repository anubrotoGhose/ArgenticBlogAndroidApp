package com.example.argenticblog

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.argenticblog.model.Post
import com.example.argenticblog.ui.theme.ArgenticBlogTheme
import com.example.argenticblog.ui.screens.HomeScreen
import com.example.argenticblog.ui.screens.PostDetailScreen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream

//import io.github.jan.supabase.createSupabaseClient
//import io.github.jan.supabase.postgrest.Postgrest
//import io.github.jan.supabase.postgrest.from
//import io.github.jan.supabase.postgrest.postgrest
//import io.github.jan.supabase.postgrest.query.Columns
//import io.github.jan.supabase.postgrest.query.Order
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.withContext

//val supabase = createSupabaseClient(
//    supabaseUrl = "https://pgpevfnwbddeankyqrhz.supabase.co",
//    supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InBncGV2Zm53YmRkZWFua3lxcmh6Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3MzUxMDgyNjYsImV4cCI6MjA1MDY4NDI2Nn0.2uy7ARaQo85Q0weKCwreLvB-jS-bGwuhOIb4IKObVSw"
//) {
//    install(Postgrest)
//}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "onCreate called")
//        setContent {
//            ArgenticBlogTheme {
//                HomeScreen(
//                    isLoggedIn = false,
//                    posts = listOf(
//                        Post("1", "First Post", "Alice", "2025-03-23", "This is the first post...", "alice123", "March 23, 2025"),
//                        Post("2", "Second Post", "Bob", "2025-03-23", "This is the second post...", "bob_456", "March 23, 2025")
//                    )
//                )
//            }
//
//        }
        copyDatabaseIfNeeded(this)
        setContent {
            ArgenticBlogTheme {
                val selectedPost = remember { mutableStateOf<Post?>(null) }

                if (selectedPost.value == null) {
                    HomeScreenWithDatabase(
                        context = this,
                        navigateToDetail = { post -> selectedPost.value = post } // Navigate to detail
                    )
                } else {
                    PostDetailScreen(
                        post = selectedPost.value!!,
                        onBack = {
                            Log.d("MainActivity", "Back pressed, going to HomeScreen")
                            selectedPost.value = null // Go back to HomeScreen
                        }
                    )
                }
            }
        }
//        setContent {
//            ArgenticBlogTheme {
//                HomeScreenWithDatabase(context = this)
//            }
//        }
    }
}

private fun copyDatabaseIfNeeded(context: Context) {
    val dbFile = File(context.getDatabasePath("argenticblog.db").path)
    if (!dbFile.exists()) {
        context.assets.open("argenticblog.db").use { inputStream ->
            FileOutputStream(dbFile).use { outputStream ->
                inputStream.copyTo(outputStream)
            }
        }
    }
}

@Composable
fun HomeScreenWithDatabase(context: Context, navigateToDetail: (Post) -> Unit) {
    val posts = remember { mutableStateOf(emptyList<Post>()) }

    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            try {
                val repository = Repository(context)
                val fetchedPosts = repository.getArticles()
                posts.value = fetchedPosts
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    HomeScreen(isLoggedIn = false, posts = posts.value, navigateToDetail = navigateToDetail)
}


//@Composable
//fun HomeScreenWithDatabase(context: Context) {
//    val posts = remember { mutableStateOf(emptyList<Post>()) }
//
//    LaunchedEffect(Unit) {
//        withContext(Dispatchers.IO) {
//            try {
//                val repository = Repository(context)
//                val fetchedPosts = repository.getArticles()
//                posts.value = fetchedPosts
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//        }
//    }
//
//    HomeScreen(isLoggedIn = false, posts = posts.value)
//}

//@Composable
//fun CallingHomeScreening() {
//    val posts = remember { mutableStateOf(emptyList<Post>()) }
//
//    LaunchedEffect(Unit) {
//        withContext(Dispatchers.IO) {
//            try {
//                val response = supabase.from("articles")
//                    .select(columns = Columns.list("articleid", "title", "username", "PostTimeStamp", "content"))
//                    { order(column = "PostTimeStamp", order = Order.DESCENDING) }
////                    .limit(count = 10)
//                    .decodeList<Map<String, Any>>()  // Decode response
//
//                val fetchedPosts = response.map { post: Map<String, Any> ->
//                    Post(
//                        articleId = post["articleid"].toString(),
//                        title = post["title"].toString(),
//                        author = post["username"].toString(),
//                        date = post["PostTimeStamp"].toString(),
//                        content = post["content"]?.toString() ?: "No content available",
//                        username = post["username"].toString(),
//                        timestamp = post["PostTimeStamp"].toString()
//                    )
//                }
//
//                posts.value = fetchedPosts
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//        }
//    }

//    HomeScreen(isLoggedIn = false, posts = posts.value)
//    HomeScreen(
//        isLoggedIn = false,
//        posts = listOf(
//            Post("1", "First Post", "Alice", "2025-03-23", "This is the first post...", "alice123", "March 23, 2025"),
//            Post("2", "Second Post", "Bob", "2025-03-23", "This is the second post...", "bob_456", "March 23, 2025")
//        )
//    )
//}
//
//
//
//@Preview(showBackground = true)
//@Composable
//fun PreviewHomeScreen() {
//    ArgenticBlogTheme {
//        HomeScreen(
//            isLoggedIn = false,
//            posts = listOf(
//                Post("1", "First Post", "Alice", "2025-03-23", "This is the first post...", "alice123", "March 23, 2025"),
//                Post("2", "Second Post", "Bob", "2025-03-23", "This is the second post...", "bob_456", "March 23, 2025")
//            )
//        )
//    }
//}


