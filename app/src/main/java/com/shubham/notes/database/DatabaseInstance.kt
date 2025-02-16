package com.shubham.notes.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [NoteEntity::class], version = 1, exportSchema = false)
abstract class DatabaseInstance : RoomDatabase() {

    /**
     * provide the dao implementation
     * **/
    abstract fun daoImpl(): NoteDao
}