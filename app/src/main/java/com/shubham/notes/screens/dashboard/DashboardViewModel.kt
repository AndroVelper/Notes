package com.shubham.notes.screens.dashboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shubham.notes.database.DataBaseEvents
import com.shubham.notes.database.NoteEntity
import com.shubham.notes.repo.Repository
import kotlinx.coroutines.launch

class DashboardViewModel(private val repository: Repository) : ViewModel() {

    private val _notes = MutableLiveData<List<NoteEntity>>()
    val notes get() = _notes

    fun fireEvent(event: DataBaseEvents) {
        when (event) {
            is DataBaseEvents.UpsertDataEvent -> {
                upsertData(event.data)
            }

            is DataBaseEvents.ClearDataBase -> {
                clearAllData()
            }

            is DataBaseEvents.DeleteNoteDataEvent -> {
                deleteNoteFromDB(event.data)
            }

            is DataBaseEvents.DeleteDataBasedOnIdEvent -> {
                deleteDataBasedOnId(event.id)
            }

            is DataBaseEvents.GetAllNotes -> {
                getAllNotes()
            }

            is DataBaseEvents.GetSpecificNoteBasedOnId -> {
                getNotesBasedOnId(event.id)
            }

            is DataBaseEvents.GetNoteBasedOnContent -> {
                getNoteBasedContent(event.content)
            }

            is DataBaseEvents.GetNotesByPagination -> {
                getNotesByPagination(event.limit, event.offset)
            }
        }
    }

    private fun upsertData(data: NoteEntity) {
        viewModelScope.launch {
            repository.upsertData(data)
        }
    }

    private fun clearAllData() {
        viewModelScope.launch {
            repository.deleteAllData()
        }
    }

    private fun getNotesByPagination(limit: Int, offset: Int) {
        viewModelScope.launch {
            repository.getPaginatedData(limit, offset)
        }
    }

    private fun getNoteBasedContent(content: String) {
        viewModelScope.launch {
            repository.getNoteBasedOnContent(content)
        }
    }

    private fun getNotesBasedOnId(id: Int) {
        viewModelScope.launch {
            repository.getSpecificNoteBasedOnId(id)
        }
    }

    private fun getAllNotes() {
        viewModelScope.launch {
            repository.getAllNotes()
        }
    }

    private fun deleteDataBasedOnId(id: Int) {
        viewModelScope.launch { repository.deleteDataBasedOnId(id) }
    }

    private fun deleteNoteFromDB(note: NoteEntity) {
        viewModelScope.launch {
            repository.deleteData(note)
        }
    }


}