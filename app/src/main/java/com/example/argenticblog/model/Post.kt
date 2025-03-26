package com.example.argenticblog.model

data class Post(
    val articleId: String,
    val title: String,
    val author: String,
    val date: String,
    val content: String,
    val username: String,
    val timestamp: String
)