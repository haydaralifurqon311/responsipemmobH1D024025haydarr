package com.pemmob.haydarbuku.data.model

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    val docs: List<BookDoc>? = null
)

data class BookDoc(
    val key: String? = null,
    val title: String? = null,
    @SerializedName("author_name") val authorName: List<String>? = null,
    @SerializedName("first_publish_year") val firstPublishYear: Int? = null,
    @SerializedName("edition_count") val editionCount: Int? = null,
    val language: List<String>? = null
)

// Extension functions + null safety
fun BookDoc.displayTitle(): String = title ?: "Tanpa judul"
fun BookDoc.displayAuthor(): String = authorName?.joinToString(", ") ?: "Penulis tidak diketahui"
fun BookDoc.displayYear(): String = firstPublishYear?.toString() ?: "-"
fun BookDoc.displayEditions(): String = editionCount?.toString() ?: "-"
fun BookDoc.displayLanguages(): String =
    language?.take(8)?.joinToString(", ") { it.uppercase() } ?: "-"