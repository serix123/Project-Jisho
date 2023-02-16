package com.example.appnavfragment.domain

import javax.inject.Inject

class VocabularyUseCaseImpl @Inject constructor(private val repository: VocabularyRepository ):VocabularyUseCase {
    override suspend fun getAllVocabularyAsCoroutines(): List<Vocabulary> {
        return repository.getAllVocabularyAsCoroutines()
    }

    override suspend fun searchVocabularyAsCoroutines(vocabularyID: Int): Vocabulary {
        return repository.searchVocabularyAsCoroutines(vocabularyID = vocabularyID)
    }

    override suspend fun insertVocabulary(vocabulary: Vocabulary) {
        return repository.insertVocabulary(vocabulary = vocabulary)
    }

    override suspend fun deleteVocabulary(vocabulary: Vocabulary) {
        return repository.deleteVocabulary(vocabulary = vocabulary)
    }
}