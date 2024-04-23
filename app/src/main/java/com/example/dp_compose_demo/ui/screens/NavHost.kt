package com.example.dp_compose_demo.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.paging.ExperimentalPagingApi
import coil.annotation.ExperimentalCoilApi
import com.example.dp_compose_demo.ui.screens.search.SearchScreen
import com.example.dp_compose_demo.utils.NavRoutes

@OptIn(ExperimentalPagingApi::class, ExperimentalCoilApi::class)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavRoutes.HOME_SCREEN) {
        composable(NavRoutes.HOME_SCREEN) {
            HomeScreen(navController = navController)
        }
        composable(NavRoutes.SEARCH_SCREEN) {
            SearchScreen(navController = navController)
        }
        composable("${NavRoutes.DETAIL_SCREEN}/{id}",
            arguments = listOf(
                navArgument(
                    name = "id"
                ) {
                    type = NavType.IntType
                }
            )
        ) {id->
            id.arguments?.getInt("id")?.let { id1->
                DetailsScreen(id =id1)
            }

        }
    }
}