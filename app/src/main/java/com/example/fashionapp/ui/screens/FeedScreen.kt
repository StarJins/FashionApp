@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.fashionapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FeedScreen(onOpenPost: (Long) -> Unit) {
    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { Text("게시글 보기") }) }
    ) { padding ->
        Column(Modifier.padding(padding).padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            ElevatedCard(
                Modifier.fillMaxWidth().clickable { onOpenPost(1L) }
            ) { Text("샘플 게시글 #1 (탭해서 상세)", Modifier.padding(16.dp)) }

            ElevatedCard(
                Modifier.fillMaxWidth().clickable { onOpenPost(2L) }
            ) { Text("샘플 게시글 #2 (탭해서 상세)", Modifier.padding(16.dp)) }
        }
    }
}