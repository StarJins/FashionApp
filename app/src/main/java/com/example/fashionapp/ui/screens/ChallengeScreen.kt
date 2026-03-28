@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.fashionapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ChallengeScreen() {
    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { Text("챌린지 리그") }) }
    ) { padding ->
        Box(Modifier.padding(padding).fillMaxSize(), contentAlignment = androidx.compose.ui.Alignment.Center) {
            Text("챌린지 화면(추후 구현)")
        }
    }
}