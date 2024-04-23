package com.example.dp_compose_demo.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.dp_compose_demo.data.models.MovieData
import com.example.dp_compose_demo.data.repos.MovieRepository

//import com.example.paging3demo.data.remote.UnsplashApi
//import com.example.paging3demo.model.UnsplashImage
//import com.example.paging3demo.util.Constants.ITEMS_PER_PAGE

class SearchPagingSource(
    private val repository: MovieRepository,
    private val query: String
) : PagingSource<Int, MovieData>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieData> {
        val currentPage = params.key ?: 1
        return try {
            val response = repository.getMoviesBySearch(movie = query)

//            if (response.isSuccessful){
//                response.body()?.data.isEmpty()
//            }

            val endOfPaginationReached = response.body()!!.data.isEmpty()
            if (response.body()!!.data.isNotEmpty()) {
                LoadResult.Page(
                    data = response.body()!!.data,
                    prevKey = if (currentPage == 1) null else currentPage - 1,
                    nextKey = if (endOfPaginationReached) null else currentPage + 1
                )
            } else {
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = null,
                    nextKey = null
                )
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, MovieData>): Int? {
        return state.anchorPosition
    }

}