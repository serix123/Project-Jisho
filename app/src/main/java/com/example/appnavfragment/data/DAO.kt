package com.example.appnavfragment.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.appnavfragment.domain.Vocabulary
import kotlinx.coroutines.flow.Flow

@Dao
interface DAO {

    @Query("SELECT * FROM vocabulary_item")
    suspend fun getAllVocabularyAsCoroutines(): List<Vocabulary>

    @Query("SELECT * FROM vocabulary_item WHERE vocabulary_item.id = :vocabularyID")
    suspend fun searchVocabularyAsCoroutines(vocabularyID: Int): Vocabulary?

    @Query("SELECT * FROM vocabulary_item")
    fun getAllVocabularyAsFlow(): Flow<List<Vocabulary>>

    @Query("SELECT * FROM vocabulary_item WHERE vocabulary_item.id = :vocabularyID")
    fun searchVocabularyAsFlow(vocabularyID: Int): Flow<Vocabulary>

    @Query("SELECT * FROM vocabulary_item")
    fun getAllVocabularyAsLiveData(): LiveData<List<Vocabulary>>

    @Query("SELECT * FROM vocabulary_item WHERE vocabulary_item.id = :vocabularyID")
    fun searchVocabularyAsLiveData(vocabularyID: Int): LiveData<Vocabulary>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVocabulary(vocabulary: Vocabulary)

    @Delete
    suspend fun deleteVocabulary(vocabulary: Vocabulary)
}