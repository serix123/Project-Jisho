package com.example.appnavfragment.domain

interface VocabularyUseCase {
    suspend fun getAllVocabularyAsCoroutines(): List<Vocabulary>

    suspend fun searchVocabularyAsCoroutines(vocabularyID: Int): Vocabulary

    suspend fun insertVocabulary(vocabulary: Vocabulary)

    suspend fun deleteVocabulary(vocabulary: Vocabulary)
}