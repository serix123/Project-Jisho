package com.example.appnavfragment.domain

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

enum class Category {
    NOUN, ADJECTIVE, EXPRESSION, VERB, DEFAULT
}

@Entity(tableName = "vocabulary_item")
data class Vocabulary(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
//    @ColumnInfo(defaultValue = Category.DEFAULT) val category: Category?,
    val word: String,
    val meaning: String,
    val kanji: String?
)
