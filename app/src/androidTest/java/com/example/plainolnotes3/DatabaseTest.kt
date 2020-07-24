package com.example.plainolnotes3

import android.util.Log
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.plainolnotes3.database.AppDatabase
import com.example.plainolnotes3.database.NoteDao
import com.example.plainolnotes3.utilities.SampleData
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DatabaseTest {
    val TAG = "Junit"
    private lateinit var mDb: AppDatabase
    private lateinit var mDao: NoteDao

   @Before
   fun createDb() {
       val context = InstrumentationRegistry.getInstrumentation().targetContext
       mDb = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
       mDao = mDb.noteDao()!!
       mDao.insertAll(SampleData().getNotes())
       Log.i(TAG, "createDb")
   }

   @After
   fun closeDb() {
       mDb.close()
   }

    @Test
    fun databaseCreatedAndPopulatedWithNotes() {
        val count = mDao.getCount()
        Log.i(TAG, "createAndRetrieveNotes: count=$count")
        assertEquals(SampleData().getNotes().count(), count)
    }

    @Test
    fun compareStrings() {
        val original = SampleData().getNotes()[0]
        val noteFromDb = mDao.getNoteById(1)
        assertEquals(original.text, noteFromDb.text)
    }
}
