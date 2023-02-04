package com.example.appnavfragment.domain

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow

interface VocabularyRepository {
    suspend fun getAllVocabularyAsCoroutines(word: String): List<Vocabulary>

    suspend fun searchVocabularyAsCoroutines(vocabularyID: Int): Vocabulary

    fun getAllVocabularyAsFlow(word: String): Flow<List<Vocabulary>>

    fun searchVocabularyAsFlow(vocabularyID: Int): Flow<Vocabulary>

    fun getAllVocabularyAsLiveData(word: String): LiveData<List<Vocabulary>>

    fun searchVocabularyAsLiveData(vocabularyID: Int): LiveData<Vocabulary>

    fun insertVocabulary(vocabulary: Vocabulary)

    fun deleteVocabulary(vocabulary: Vocabulary)

}