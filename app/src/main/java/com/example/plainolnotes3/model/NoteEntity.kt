package com.example.plainolnotes3.model

import java.util.*

data class NoteEntity(
    var noteId: Int? = null,
    var date: Date? = null,
    var text: String? = null
) {
    fun getNoteDataString() :String {
        return "NoteEntity {id=$noteId, date=$date, text=$text}"
    }
}
