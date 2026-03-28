@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.fashionapp.app

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fashionapp.ui.screens.*

@Composable
fun AppRoot() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Route.Home.value
    ) {
        composable(Route.Home.value) {
            HomeScreen(
                onUpload = { navController.navigate(Route.Upload.value) },
                onMyPage = { navController.navigate(Route.MyPage.value) },
                onFeed = { navController.navigate(Route.Feed.value) },
                onChallenge = { navController.navigate(Route.Challenge.value) }
            )
        }
        composable(Route.Upload.value) {
            UploadScreen(
                onDone = { createdPostId ->
                    navController.navigate(Route.Detail.create(createdPostId))
                }
            )
        }
        composable(Route.Feed.value) {
            FeedScreen(
                onOpenPost = { postId ->
                    navController.navigate(Route.Detail.create(postId))
                }
            )
        }
        composable(Route.MyPage.value) {
            MyPageScreen(
                onOpenPost = { postId ->
                    navController.navigate(Route.Detail.create(postId))
                }
            )
        }
        composable(Route.Challenge.value) { ChallengeScreen() }

        composable(Route.Detail.value) { backStackEntry ->
            val postId = backStackEntry.arguments?.getString("postId")!!.toLong()
            PostDetailScreen(postId = postId)
        }
    }
}