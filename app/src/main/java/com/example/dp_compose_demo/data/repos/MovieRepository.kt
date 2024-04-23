package com.example.dp_compose_demo.data.repos

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.dp_compose_demo.data.models.MovieData
import com.example.dp_compose_demo.data.models.MovieDetails
import com.example.dp_compose_demo.data.models.MovieListResponse
import com.example.dp_compose_demo.data.paging.SearchPagingSource
import com.example.dp_compose_demo.network.MovieApiService
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieApiService: MovieApiService
) {
    suspend fun getMovieList(page:Int): Response<MovieListResponse> {
        return movieApiService.getMovies(page)
    }
    suspend fun getDetailsById(id:Int): Response<MovieDetails>{
        return movieApiService.getDetailsById(id = id)
    }

    suspend fun getMoviesBySearch(movie:String): Response<MovieListResponse>{
        return movieApiService.getMoviesBySearch(movie)
    }

    fun searchImages(query: String): Flow<PagingData<MovieData>> {
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            pagingSourceFactory = {
                SearchPagingSource(repository = this, query = query)
            }
        ).flow
    }

    companion object{
        const val ITEMS_PER_PAGE = 10
    }

}