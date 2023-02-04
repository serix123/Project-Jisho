package com.example.appnavfragment.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

enum class Category {
    NOUN, ADJECTIVE, EXPRESSION, VERB
}

@Entity(tableName = "vocabulary_item")
data class Vocabulary(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val category: Category? = null,
    val word: String,
    val meaning: String,
    val kanji: String? = null
)
