package com.example.appnavfragment.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.appnavfragment.domain.Vocabulary

@Database(entities = [Vocabulary::class], version = 1, exportSchema = false)
abstract class VocabularyDatabase:RoomDatabase() {
    abstract fun dao():DAO

    companion object{
        @Volatile
        private var INSTANCE: VocabularyDatabase? = null

        fun getDatabase(context: Context): VocabularyDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                   VocabularyDatabase::class.java,
                    "task_item_database").build()
                INSTANCE = instance
                instance
            }
        }
    }

}