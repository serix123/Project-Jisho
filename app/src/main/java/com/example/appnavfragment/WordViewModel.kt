package com.example.appnavfragment

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WordViewModel : ViewModel() {
    private var _vocabulary = MutableLiveData<List<Word>>().apply { value = emptyList() }
    val vocabulary: LiveData<List<Word>> = _vocabulary

    fun addVocabulary(word: Word){

        _vocabulary.value = _vocabulary.value!!.toMutableList().apply {
            add(word)
            Log.d("MSG", "$word")
        }

    }
}