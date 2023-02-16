package com.example.appnavfragment.dependency_injection

import android.content.Context
import androidx.room.Room
import com.example.appnavfragment.data.DAO
import com.example.appnavfragment.data.Database
import com.example.appnavfragment.data.VocabularyRepositoryImpl
import com.example.appnavfragment.domain.VocabularyRepository
import com.example.appnavfragment.domain.VocabularyUseCase
import com.example.appnavfragment.domain.VocabularyUseCaseImpl
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
    fun provideVocabularyDB(@ApplicationContext context: Context):Database =
        Room.databaseBuilder(context, Database::class.java, "Product_Database").build()

    @Singleton
    @Provides
    fun provideDao(database: Database):DAO = database.dao()

    @Singleton
    @Provides
    fun provideRepository( dao: DAO):VocabularyRepository {
        return VocabularyRepositoryImpl(dao = dao)
    }
    @Singleton
    @Provides
    fun provideUseCase( repository: VocabularyRepository):VocabularyUseCase {
        return VocabularyUseCaseImpl(repository = repository)
    }

}