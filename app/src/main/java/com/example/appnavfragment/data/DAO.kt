package com.example.appnavfragment.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.appnavfragment.domain.Vocabulary
import kotlinx.coroutines.flow.Flow

@Dao
interface DAO {

    @Query("SELECT * FROM vocabulary_item")
    suspend fun getAllVocabularyAsCoroutines(word: String): List<Vocabulary>

    @Query("SELECT * FROM vocabulary_item WHERE vocabulary_item.id = :vocabularyID")
    suspend fun searchVocabularyAsCoroutines(vocabularyID: Int): Vocabulary

    @Query("SELECT * FROM vocabulary_item")
    fun getAllVocabularyAsFlow(word: String): Flow<List<Vocabulary>>

    @Query("SELECT * FROM vocabulary_item WHERE vocabulary_item.id = :vocabularyID")
    fun searchVocabularyAsFlow(vocabularyID: Int): Flow<Vocabulary>

    @Query("SELECT * FROM vocabulary_item")
    fun getAllVocabularyAsLiveData(word: String): LiveData<List<Vocabulary>>

    @Query("SELECT * FROM vocabulary_item WHERE vocabulary_item.id = :vocabularyID")
    fun searchVocabularyAsLiveData(vocabularyID: Int): LiveData<Vocabulary>

    @Insert
    fun insertVocabulary(vocabulary: Vocabulary)

    @Delete
    fun deleteVocabulary(vocabulary: Vocabulary)
}