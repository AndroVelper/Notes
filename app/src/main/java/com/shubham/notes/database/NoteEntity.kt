package com.shubham.notes.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serial

@Entity(tableName = "NotesDB")
data class NoteEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val content: String,
    val timestamp: Long = System.currentTimeMillis()
)