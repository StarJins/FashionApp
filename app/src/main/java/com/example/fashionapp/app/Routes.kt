package com.example.fashionapp.app

sealed class Route(val value: String) {
    data object Home : Route("home")
    data object Upload : Route("upload")
    data object Feed : Route("feed")
    data object MyPage : Route("mypage")
    data object Challenge : Route("challenge")
    data object Detail : Route("detail/{postId}") {
        fun create(postId: Long) = "detail/$postId"
    }
}