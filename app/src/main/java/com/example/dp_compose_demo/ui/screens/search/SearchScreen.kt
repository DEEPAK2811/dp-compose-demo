package com.example.dp_compose_demo.ui.screens.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.ExperimentalPagingApi
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi

@ExperimentalPagingApi
@ExperimentalCoilApi
@Composable
fun SearchScreen(
    navController: NavHostController,
) {
    val searchViewModel: SearchViewModel = hiltViewModel()
    val searchQuery by searchViewModel.searchQuery
    val searchedMovies = searchViewModel.searchedMovies.collectAsLazyPagingItems()

    Scaffold(modifier = Modifier.background(Color.Transparent),
        topBar = {
            SearchWidget(
                text = searchQuery,
                onTextChange = {
                    searchViewModel.updateSearchQuery(query = it)
                },
                onSearchClicked = {
                    searchViewModel.searchHeroes(query = it)
                },
                onCloseClicked = {
                    navController.popBackStack()
                }
            )
        },
        content = { paddingValues->
            Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(
                    Color.Transparent
                )
            ListContent(items = searchedMovies,navController)
        },
        containerColor = Color.Transparent
    )
}