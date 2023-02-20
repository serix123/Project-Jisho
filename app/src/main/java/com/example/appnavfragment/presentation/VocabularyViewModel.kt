package com.example.appnavfragment.presentation

import androidx.lifecycle.*
import com.example.appnavfragment.domain.Vocabulary
import com.example.appnavfragment.domain.VocabularyUseCase
import com.example.appnavfragment.domain.VocabularyUseCaseImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VocabularyViewModel @Inject constructor(private val vocabularyUseCase: VocabularyUseCase) :
    ViewModel() {

    private val _vocabularyLiveData = MutableLiveData<List<Vocabulary>>()
    val vocabularyLiveData: LiveData<List<Vocabulary>> = _vocabularyLiveData

    fun insertVocabulary(vocabulary: Vocabulary) {
        viewModelScope.launch {
            vocabularyUseCase.insertVocabulary(vocabulary)
        }
    }

    fun getAllVocabulary() {
        viewModelScope.launch {
            val response = vocabularyUseCase.getAllVocabularyAsCoroutines()
            _vocabularyLiveData.postValue(response)
        }
    }

    fun deleteVocabulary(vocabulary: Vocabulary) {
        viewModelScope.launch {
            vocabularyUseCase.deleteVocabulary(vocabulary)
        }
    }

    fun searchVocabulary(vocabularyID: Int) {
        viewModelScope.launch {
            vocabularyUseCase.searchVocabularyAsCoroutines(vocabularyID)
        }
    }

}

class VocabularyViewModelFactory @Inject constructor(private val vocabularyUseCase: VocabularyUseCase) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(VocabularyViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return VocabularyViewModel(vocabularyUseCase = vocabularyUseCase) as T
        }
        throw  IllegalArgumentException("Invalid ViewModel Class")
    }
}
