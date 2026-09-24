package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.data.book.DefaultBookRepository
import com.example.data.local.ReaderDatabase
import com.example.data.preferences.ReaderPreferences
import com.example.data.repository.UserDataRepository
import com.example.ui.BookReaderViewModel
import com.example.ui.navigation.BookNavGraph
import com.example.ui.theme.IaNaPraticaTheme

class MainActivity : ComponentActivity() {

    private val viewModel: BookReaderViewModel by viewModels {
        val database = ReaderDatabase.getInstance(applicationContext)
        val preferences = ReaderPreferences(applicationContext)
        val userDataRepository = UserDataRepository(database.readerDao(), preferences)
        val bookRepository = DefaultBookRepository()
        BookReaderViewModel.Factory(bookRepository, userDataRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val settings by viewModel.readerSettings.collectAsState()

            IaNaPraticaTheme(themeMode = settings.themeMode) {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()
                    BookNavGraph(
                        navController = navController,
                        viewModel = viewModel,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}
