package com.example.argenticblog


import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.argenticblog.model.Post

class Repository(context: Context) : SQLiteOpenHelper(context, "argenticblog.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        // This method is only called if the database is newly created.
        Log.d("Repository", "onCreate called, but DB already exists in assets.")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // Handle database upgrades if needed
    }

    fun getArticles(): List<Post> {
        val articles = mutableListOf<Post>()
        val db = readableDatabase
        val query = "SELECT articleid, title, username, PostTimeStamp, content FROM articles ORDER BY PostTimeStamp DESC LIMIT 10"
        val cursor = db.rawQuery(query, null)

        while (cursor.moveToNext()) {
            val articleId = cursor.getString(0)
            val title = cursor.getString(1)
            val author = cursor.getString(2)
            val date = cursor.getString(3)
            val content = cursor.getString(4) ?: "No content available"

            articles.add(Post(articleId, title, author, date, content, author, date))
        }

        cursor.close()
        db.close()
        return articles
    }
}
