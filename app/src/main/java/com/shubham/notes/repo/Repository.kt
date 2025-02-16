package com.shubham.notes.repo

import com.shubham.notes.database.NoteDao
import com.shubham.notes.database.NoteEntity


class Repository(private val databaseOperation: NoteDao) {
    suspend fun upsertData(note: NoteEntity) = databaseOperation.insertNode(note)
    suspend fun getAllNotes() = databaseOperation.getAllNotes()
    suspend fun deleteData(note: NoteEntity) = databaseOperation.deleteNote(note)
    suspend fun deleteDataBasedOnId(id: Int) = databaseOperation.deleteNoteBasedOnId(id)
    suspend fun deleteAllData() = databaseOperation.deleteAllFromMyTable()
    suspend fun getNoteBasedOnContent(content: String) =
        databaseOperation.getNoteBasedOnTitle(content)

    suspend fun getPaginatedData(limit: Int, offset: Int) =
        databaseOperation.getNotesByPagination(limit, offset)

    suspend fun getSpecificNoteBasedOnId(id: Int) = databaseOperation.getSpecificNoteBasedOnId(id)


}