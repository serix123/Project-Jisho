package com.example.appnavfragment.presentation

import androidx.lifecycle.ViewModel
import com.example.appnavfragment.domain.VocabularyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class VocabularyViewModel @Inject constructor(val valrepository: VocabularyRepository ) :ViewModel() {




}