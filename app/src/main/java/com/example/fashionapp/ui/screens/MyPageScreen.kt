@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.fashionapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyPageScreen(onOpenPost: (Long) -> Unit) {
    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { Text("마이페이지") }) }
    ) { padding ->
        Column(Modifier.padding(padding).padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text("내 정보(나중에 추가)")

            ElevatedCard(
                Modifier.fillMaxWidth().clickable { onOpenPost(1L) }
            ) { Text("내 게시글 #1", Modifier.padding(16.dp)) }
        }
    }
}