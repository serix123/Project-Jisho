package com.example.appnavfragment.presentation.components

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appnavfragment.databinding.VocabularyListItemBinding
import com.example.appnavfragment.domain.Vocabulary

class VocabularyListAdapter(private val vocabularyList: List<Vocabulary>) :
    RecyclerView.Adapter<VocabularyListAdapter.VocabularyViewHolder>() {


    inner class VocabularyViewHolder(val binding: VocabularyListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindVocabularyItems(vocabulary: Vocabulary) {
            binding.wordTextView.text = vocabulary.word
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VocabularyViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = VocabularyListItemBinding.inflate(layoutInflater, parent, false)
        return VocabularyViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: VocabularyViewHolder, position: Int) {
        holder.bindVocabularyItems(vocabularyList[position])
//        holder.binding.apply {
//            wordTextView.text = vocabularyList[position].word
//        }
    }

    override fun getItemCount(): Int = vocabularyList.size
}