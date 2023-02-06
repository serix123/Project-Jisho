package com.example.appnavfragment.data

import androidx.lifecycle.LiveData
import com.example.appnavfragment.domain.Vocabulary
import com.example.appnavfragment.domain.VocabularyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class VocabularyRepositoryImpl @Inject constructor(private val dao: DAO):VocabularyRepository {
    override suspend fun getAllVocabularyAsCoroutines(word: String): List<Vocabulary> {
        return dao.getAllVocabularyAsCoroutines(word)
    }

    override suspend fun searchVocabularyAsCoroutines(vocabularyID: Int): Vocabulary {
        return dao.searchVocabularyAsCoroutines(vocabularyID)
    }

    override fun getAllVocabularyAsFlow(word: String): Flow<List<Vocabulary>> {
        return dao.getAllVocabularyAsFlow(word)
    }

    override fun searchVocabularyAsFlow(vocabularyID: Int): Flow<Vocabulary> {
        return dao.searchVocabularyAsFlow(vocabularyID)
    }

    override fun getAllVocabularyAsLiveData(word: String): LiveData<List<Vocabulary>> {
        return dao.getAllVocabularyAsLiveData(word)
    }

    override fun searchVocabularyAsLiveData(vocabularyID: Int): LiveData<Vocabulary> {
        return dao.searchVocabularyAsLiveData(vocabularyID)
    }

    override fun insertVocabulary(vocabulary: Vocabulary) {
        return dao.insertVocabulary(vocabulary)
    }

    override fun deleteVocabulary(vocabulary: Vocabulary) {
        return dao.deleteVocabulary(vocabulary)
    }
}