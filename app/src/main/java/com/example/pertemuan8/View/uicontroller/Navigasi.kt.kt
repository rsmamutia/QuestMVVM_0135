package com.example.pertemuan8.View.uicontroller

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.pertemuan8.viewmodel.SiswaViewModel

enum class Navigasi {
    Formulir,
    Detail
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SiswaApp(
    //edit 1 : parameter viewModel
    modifier: Modifier,
    viewModel: SiswaViewModel = viewModel(),
    navController: NavHostController = rememberNavController(),
    collectAsState: Any.() -> Unit
){
    Scaffold { isiRuang->
        //edit 2 : tambahkan variabel uiState
        val uiState = viewModel.statusUI.collectAsState()
        NavHost(
            navController = navController,
            startDestination = Navigasi.Formulir.name,
}