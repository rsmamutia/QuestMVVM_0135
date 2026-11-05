package com.example.pertemuan8.View.uicontroller

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
    collectAsState: Any.() -> Unit,
    cancelAndBackToFormulir: (NavHostController) -> cancelAndBackToFormulir
){
    Scaffold { isiRuang->
        //edit 2 : tambahkan variabel uiState
        val uiState = viewModel.statusUI.collectAsState()
        NavHost(
            navController = navController,
            startDestination = Navigasi.Formulir.name,

            modifier = Modifier.padding(isiRuang)){
            composable(route = Navigasi.Formulir.name) {
                //edit 3 : tambahkan variable konteks
                val konteks = LocalContext.current
                FormSiswa(
                    //edit 4 : parameter pilihanJK dan onSubmitButtonClicked
                    pilihanJK = JenisK.map { id -> konteks.resources.getString(id) },
                    onSubmitButtonClicked = {
                        viewModel.setSiswa(it)
                        navController.navigate(Navigasi.Detail.name)
                    }
                )
            }

            composable(route = Navigasi.Detail.name){
                TampilSiswa(
                    //edit 5 : parameter statusUISiswa
                    statusUISiswa = uiState.value,
                    onBackButtonClicked = { cancelAndBackToFormulir(navController) }
                )
            }
        }
    }
}

@Composable
fun TampilSiswa(statusUISiswa: value, onBackButtonClicked: () -> cancelAndBackToFormulir) {
    TODO("Not yet implemented")
}

@Composable
fun FormSiswa(pilihanJK: ERROR, onSubmitButtonClicked: () -> Unit) {
    TODO("Not yet implemented")
}