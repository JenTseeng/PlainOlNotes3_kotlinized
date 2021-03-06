package com.example.plainolnotes3.database

import androidx.room.TypeConverter
import java.util.Date

class DateConverter {
    companion object
    @TypeConverter
    fun toDate(timestamp: Long?): Date? {
        return if (timestamp == null) null else Date(timestamp)
    }

    @TypeConverter
    fun toTimestamp(date: Date?): Long? {
        return date?.time
    }
}
