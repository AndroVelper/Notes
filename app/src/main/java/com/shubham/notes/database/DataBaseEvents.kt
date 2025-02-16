package com.shubham.notes.database

sealed interface DataBaseEvents {
    data class UpsertDataEvent(val data: NoteEntity) : DataBaseEvents
    data object ClearDataBase : DataBaseEvents
    data class DeleteNoteDataEvent(val data: NoteEntity) : DataBaseEvents
    data class DeleteDataBasedOnIdEvent(val id: Int) : DataBaseEvents
    data object GetAllNotes : DataBaseEvents
    data class GetSpecificNoteBasedOnId(val id : Int ) :DataBaseEvents
    data class GetNoteBasedOnContent(val content : String) : DataBaseEvents
    data class GetNotesByPagination(val limit: Int, val offset: Int) : DataBaseEvents
}