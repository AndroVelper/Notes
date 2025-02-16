package com.shubham.notes.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert


/**
 * The method manager of the room DB all the operations are listed here
 **/

@Dao
interface NoteDao {
    /**
     * Upsert is a special entity that will insert the data and if somehow
     * it found the entity already there then it will update that entity
     *
     * @param note : the note which we want to insert or update
     * @return true -> if inserted successfully otherwise false
     * **/
    @Upsert
    suspend fun insertNode(note: NoteEntity)


    /**
     * Delete the specific note from the DB
     * @param note : Note to be deleted
     * @return true if the note is deleted otherwise false
     * **/
    @Delete
    suspend fun deleteNote(note: NoteEntity)


    /**
     * Delete all the notes from the database
     * **/
    @Query("DELETE FROM NotesDB")
    suspend fun deleteAllFromMyTable()

    /**
     * Delete the note based on the id
     * @param noteId : the id of the note to be deleted
     * @return true if the note is deleted otherwise not
     **/
    @Query("DELETE FROM NotesDB WHERE id = :noteId")
    suspend fun deleteNoteBasedOnId(noteId: Int)


    /**
     * Get all the notes from the database and return it
     **/
    @Query("SELECT * FROM NotesDB")
    suspend fun getAllNotes(): List<NoteEntity>

    /**
     * Get the specific note from the database and return that node.
     **/
    @Query("SELECT * FROM NotesDB WHERE id = :noteId")
    suspend fun getSpecificNoteBasedOnId(noteId: Int): NoteEntity


    /**
     * Get the notes based on the search deal with the data.
     **/
    @Query("SELECT * FROM NOTESDB WHERE title LIKE :title or content LIKE :title")
    suspend fun getNoteBasedOnTitle(title: String): List<NoteEntity>


    /**
     * Get the notes based on the pagination
     **/
    @Query("SELECT * FROM notesdb ORDER BY id LIMIT :limit  OFFSET :offset")
    suspend fun getNotesByPagination(limit: Int, offset: Int): List<NoteEntity>
}