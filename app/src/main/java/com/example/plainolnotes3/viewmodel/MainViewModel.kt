package com.example.plainolnotes3.viewmodel

import androidx.lifecycle.ViewModel
import com.example.plainolnotes3.utilities.SampleData

class MainViewModel : ViewModel() {

    val notes = SampleData.getNotes()
}
