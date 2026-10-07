package com.pemmob.haydarbuku.data.remote

import com.pemmob.haydarbuku.data.model.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BookApiService {
    @GET("search.json")
    suspend fun searchBooks(
        @Query("q") query: String,
        @Query("limit") limit: Int = 20,
        @Query("fields") fields: String =
            "key,title,author_name,first_publish_year,edition_count,language"
    ): SearchResponse
}