package com.pemmob.haydarbuku

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.pemmob.haydarbuku.ui.AppNavHost
import com.pemmob.haydarbuku.ui.BookViewModel
import com.pemmob.haydarbuku.ui.theme.BookFinderTheme

class MainActivity : ComponentActivity() {
    private val viewModel: BookViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookFinderTheme { AppNavHost(viewModel) }
        }
    }
}