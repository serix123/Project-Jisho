package com.example.appnavfragment.dependency_injection

import android.content.Context
import androidx.room.Room
import com.example.appnavfragment.data.Database
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideVocabularyDBDB(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, Database::class.java, "Product_Database").build()

    @Singleton
    @Provides
    fun provideDao(database: Database) = database.dao()
}