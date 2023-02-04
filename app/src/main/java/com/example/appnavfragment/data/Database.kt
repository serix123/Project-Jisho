package com.example.appnavfragment.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.appnavfragment.domain.Vocabulary

@Database(entities = [Vocabulary::class], version = 1, exportSchema = false)
abstract class Database:RoomDatabase() {
    abstract fun dao():DAO
}