package com.example.dp_compose_demo.ui.screens.search


import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.paging.compose.LazyPagingItems
//import androidx.paging.compose.items
import coil.annotation.ExperimentalCoilApi
import com.example.dp_compose_demo.data.models.MovieData
import com.example.dp_compose_demo.ui.screens.ItemUi

@ExperimentalCoilApi
@Composable
fun ListContent(items: LazyPagingItems<MovieData>, navController: NavHostController) {
    Log.d("Error", items.loadState.toString())
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(all = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    )
    {
        items(
            count = items.itemCount
        ) { idx ->
//            movie?.let { UnsplashItem(unsplashImage = it) }
            ItemUi(
                itemIndex = idx, movieList = items.itemSnapshotList.items,
                navController = navController
            )
        }
    }
}
