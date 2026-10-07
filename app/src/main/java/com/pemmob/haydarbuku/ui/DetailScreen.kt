package com.pemmob.haydarbuku.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pemmob.haydarbuku.data.model.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(book: BookDoc?, onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detail Buku", style = MaterialTheme.typography.titleLarge) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Kembali")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }
    ) { padding ->
        if (book == null) {
            Box(Modifier.padding(padding).fillMaxSize(), Alignment.Center) {
                Text("Data buku tidak ditemukan")
            }
        } else {
            Column(Modifier.padding(padding).padding(20.dp)) {
                Text(
                    book.displayTitle(),
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(Modifier.height(20.dp))
                DetailRow("Penulis", book.displayAuthor())
                DetailRow("Tahun terbit pertama", book.displayYear())
                DetailRow("Jumlah edisi", book.displayEditions())
                DetailRow("Bahasa", book.displayLanguages())
            }
        }
    }
}

@Composable
private fun DetailRow(label: String, value: String) {
    Column(Modifier.padding(bottom = 16.dp)) {
        Text(label, style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.tertiary)
        Text(value, style = MaterialTheme.typography.bodyLarge)
        HorizontalDivider(Modifier.padding(top = 8.dp))
    }
}