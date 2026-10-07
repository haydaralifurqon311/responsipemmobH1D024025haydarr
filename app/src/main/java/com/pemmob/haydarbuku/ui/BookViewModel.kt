package com.pemmob.haydarbuku.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pemmob.haydarbuku.data.model.BookDoc
import com.pemmob.haydarbuku.data.repository.BookRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed interface UiState {
    data object Loading : UiState
    data class Success(val books: List<BookDoc>) : UiState
    data class Error(val message: String) : UiState
}

class BookViewModel : ViewModel() {
    private val repository = BookRepository()

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    private val _query = MutableStateFlow("indonesia")
    val query: StateFlow<String> = _query.asStateFlow()

    private var searchJob: Job? = null

    init { search() }

    fun onQueryChange(newQuery: String) { _query.value = newQuery }

    fun search() {
        val keyword = _query.value.trim()
        if (keyword.isEmpty()) return
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = try {
                UiState.Success(repository.searchBooks(keyword))
            } catch (e: Exception) {
                UiState.Error(e.message ?: "Terjadi kesalahan, periksa koneksi internet")
            }
        }
    }

    // Detail memakai data item yang sudah ada (tanpa API call kedua)
    fun findBook(key: String?): BookDoc? =
        (_uiState.value as? UiState.Success)?.books?.firstOrNull { it.key == key }
}