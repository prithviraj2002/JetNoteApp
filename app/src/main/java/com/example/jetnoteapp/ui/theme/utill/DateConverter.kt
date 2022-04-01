package com.example.jetnoteapp.ui.theme.utill

import androidx.room.TypeConverter
import java.sql.Time
import java.util.*

class DateConverter {

    @TypeConverter
    fun timeStampfromDate(date: Date): Long{
        return date.time
    }

    @TypeConverter
    fun dateFromTimeStamp(timestamp: Long): Date?{
        return Date(timestamp)
    }
}