package com.example.ucp1

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ucp1.model.DataJK.JenisK
import com.example.ucp1.viewmodel.SiswaViewModel

enum class Navigasi {
    Formulir,
    Data
}

@Composable
fun Navigate(
    viewModel: SiswaViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {}

