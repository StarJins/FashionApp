@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.fashionapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PostDetailScreen(postId: Long) {
    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { Text("게시글") }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            ElevatedCard(Modifier.fillMaxWidth().height(260.dp)) {
                Box(Modifier.fillMaxSize(), contentAlignment = androidx.compose.ui.Alignment.Center) {
                    Text("사진 영역 (postId=$postId)")
                }
            }

            ElevatedCard(Modifier.fillMaxWidth()) {
                Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text("코디 의도", style = MaterialTheme.typography.titleSmall)
                    Text("...")

                    Divider()

                    Text("옷 브랜드", style = MaterialTheme.typography.titleSmall)
                    Text("...")

                    Divider()

                    Text("추구미", style = MaterialTheme.typography.titleSmall)
                    Text("...")
                }
            }

            ElevatedCard(Modifier.fillMaxWidth()) {
                Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text("피드백", style = MaterialTheme.typography.titleSmall)
                    Text("여기에 댓글 리스트/입력 UI를 붙이면 됨")
                }
            }
        }
    }
}