package com.example.dp_compose_demo.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.dp_compose_demo.data.models.MovieListResponse
import com.example.dp_compose_demo.data.repos.MovieRepository

//class MoviePagingSource(
//    private val repository: MovieRepository,
//    val search: String,
//): PagingSource<Int, MovieListResponse>() {
//    companion object {
//        const val PAGE_SIZE = 10
//
//        private const val INITIAL_LOAD_SIZE = 0
//    }
//
//    override fun getRefreshKey(state: PagingState<Int, MovieListResponse>): Int? {
//        return null
//    }
//
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieListResponse> {
//        return try {
//            val position = params.key ?: INITIAL_LOAD_SIZE
//            val offset = if (params.key != null) ((position - 1) * PAGE_SIZE) else INITIAL_LOAD_SIZE
//
//            val result = repository.getMoviesBySearch(
//                skip = offset,
//                limit = params.loadSize,
//                search = search,
//            )
//
//            val nextKey = if (result.products.isEmpty()) {
//                null
//            } else {
//                position + (params.loadSize / PAGE_SIZE)
//            }
//
//            return LoadResult.Page(
//                data = result.products,
//                prevKey = null,
//                nextKey = nextKey,
//            )
//        } catch (e: Throwable) {
//            LoadResult.Error(e)
//        }
//    }
//}