package com.example.plainolnotes3.database

import com.example.plainolnotes3.utilities.SampleData

object AppRepository {
    val notes: List<NoteEntity> = SampleData.getNotes()
}
