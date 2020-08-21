package com.example.plainolnotes3.viewmodel

import androidx.lifecycle.ViewModel
import com.example.plainolnotes3.database.AppRepository

class MainViewModel : ViewModel() {

    val notes = AppRepository.notes

}
