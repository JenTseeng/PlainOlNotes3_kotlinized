package com.example.plainolnotes3.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "notes")
data class NoteEntity constructor(
    @PrimaryKey(autoGenerate = true)
    val noteId: Int? = null,
    var date: Date? = null,
    var text: String? = null
) {
    fun getNoteDataString(): String {
        return "NoteEntity {id=$noteId, date=$date, text=$text}"
    }
}
