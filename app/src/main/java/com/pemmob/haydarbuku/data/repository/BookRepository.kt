package com.pemmob.haydarbuku.data.repository

import com.pemmob.haydarbuku.data.model.BookDoc
import com.pemmob.haydarbuku.data.remote.RetrofitClient

class BookRepository {
    suspend fun searchBooks(query: String): List<BookDoc> =
        RetrofitClient.api.searchBooks(query).docs.orEmpty()
}