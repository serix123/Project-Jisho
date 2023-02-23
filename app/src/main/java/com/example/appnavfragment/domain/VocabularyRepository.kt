package com.example.appnavfragment.domain

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow

interface VocabularyRepository {
    suspend fun getAllVocabularyAsCoroutines(): List<Vocabulary>

    suspend fun searchVocabularyAsCoroutines(vocabularyID: Int): Vocabulary?

    fun getAllVocabularyAsFlow(): Flow<List<Vocabulary>>

    fun searchVocabularyAsFlow(vocabularyID: Int): Flow<Vocabulary>

    fun getAllVocabularyAsLiveData(): LiveData<List<Vocabulary>>

    fun searchVocabularyAsLiveData(vocabularyID: Int): LiveData<Vocabulary>

    suspend fun insertVocabulary(vocabulary: Vocabulary)

    suspend fun deleteVocabulary(vocabulary: Vocabulary)

}