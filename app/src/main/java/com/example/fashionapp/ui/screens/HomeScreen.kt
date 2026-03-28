package com.example.fashionapp.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fashionapp.ui.components.MenuCard
import androidx.compose.ui.tooling.preview.Preview
import com.example.fashionapp.ui.theme.FashionAppTheme

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun HomeScreen(
    onUpload: () -> Unit,
    onMyPage: () -> Unit,
    onFeed: () -> Unit,
    onChallenge: () -> Unit,
) {
    val redAccent = Color(0xFFFF8E8E)
    val blueAccent = Color(0xFF9CCBFF)

    Scaffold(
        containerColor = Color.White
    ) { paddingValues ->
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(paddingValues)
        ) {
            val screenWidth = maxWidth
            val screenHeight = maxHeight

            // 화면 폭에 따라 메뉴 그룹 크기를 유연하게
            val groupWidth = if (screenWidth > 400.dp) 360.dp else screenWidth * 0.86f
            val groupHeight = 420.dp

            // 카드 크기
            val cardWidth = groupWidth * 0.6f

            // 상단 제목
            Box(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .statusBarsPadding()
                    .padding(top = 20.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "FashionApp",
                    style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 28.sp,
                        color = Color(0xFF111827)
                    )
                )
            }

            // 메뉴 4개 그룹 전체를 중앙 배치
            Box(
                modifier = Modifier
                    .align(Alignment.Center)
                    .width(groupWidth)
                    .height(groupHeight)
            ) {
                MenuCard(
                    number = "1.",
                    title = "사진 올리기",
                    accentColor = redAccent,
                    rotation = -8f,
                    onClick = onUpload,
                    modifier = Modifier
                        .width(cardWidth)
                        .align(Alignment.TopStart)
                        .offset(x = 8.dp, y = 0.dp)
                )

                MenuCard(
                    number = "2.",
                    title = "게시글 보기",
                    accentColor = blueAccent,
                    rotation = 7f,
                    onClick = onFeed,
                    modifier = Modifier
                        .width(cardWidth)
                        .align(Alignment.TopEnd)
                        .offset(x = (-10).dp, y = 100.dp)
                )

                MenuCard(
                    number = "3.",
                    title = "마이 페이지",
                    accentColor = redAccent,
                    rotation = -7f,
                    onClick = onMyPage,
                    modifier = Modifier
                        .width(cardWidth)
                        .align(Alignment.BottomStart)
                        .offset(x = 18.dp, y = (-90).dp)
                )

                MenuCard(
                    number = "4.",
                    title = "챌린지 리그",
                    accentColor = blueAccent,
                    rotation = 6f,
                    onClick = onChallenge,
                    modifier = Modifier
                        .width(cardWidth)
                        .align(Alignment.BottomEnd)
                        .offset(x = (-10).dp, y = 10.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    FashionAppTheme {
        HomeScreen(
            onUpload = {},
            onMyPage = {},
            onFeed = {},
            onChallenge = {}
        )
    }
}