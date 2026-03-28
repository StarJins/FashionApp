@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.fashionapp.ui.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun UploadScreen(
    onDone: (Long) -> Unit
) {
    var photoUri by remember { mutableStateOf<Uri?>(null) }
    var intentText by remember { mutableStateOf("") }
    var brandText by remember { mutableStateOf("") }
    var vibeText by remember { mutableStateOf("") }

    val picker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia()
    ) { uri -> photoUri = uri }

    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { Text("사진 올리기") }) }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
                    .clickable {
                        picker.launch(
                            PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                        )
                    }
            ) {
                Box(Modifier.fillMaxSize(), contentAlignment = androidx.compose.ui.Alignment.Center) {
                    Text(if (photoUri == null) "탭해서 사진 선택" else "사진 선택됨")
                }
            }

            OutlinedTextField(
                value = intentText,
                onValueChange = { intentText = it },
                label = { Text("코디 의도") },
                modifier = Modifier.fillMaxWidth(),
                minLines = 3
            )
            OutlinedTextField(
                value = brandText,
                onValueChange = { brandText = it },
                label = { Text("옷 브랜드") },
                modifier = Modifier.fillMaxWidth(),
                minLines = 2
            )
            OutlinedTextField(
                value = vibeText,
                onValueChange = { vibeText = it },
                label = { Text("추구미") },
                modifier = Modifier.fillMaxWidth(),
                minLines = 2
            )

            Button(
                onClick = {
                    val fakePostId = System.currentTimeMillis()
                    onDone(fakePostId)
                },
                enabled = photoUri != null,
                modifier = Modifier.fillMaxWidth()
            ) { Text("등록") }
        }
    }
}