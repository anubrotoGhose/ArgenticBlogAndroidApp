package com.example.argenticblog.databasehandler

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, "argenticblog.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        // No need to create tables manually, since we're using a pre-populated DB
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Handle database version upgrades if needed
    }

    fun getDatabase(): SQLiteDatabase {
        return readableDatabase
    }
}