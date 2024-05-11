package com.example.theweatherapp.db

import androidx.room.TypeConverter
import com.example.theweatherapp.models.Source

class Converters {
    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name) // Assuming Source has a constructor that takes two parameters
    }
}
