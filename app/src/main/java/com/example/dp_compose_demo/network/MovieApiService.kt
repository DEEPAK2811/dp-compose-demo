package com.example.dp_compose_demo.network

import com.example.dp_compose_demo.data.models.MovieDetails
import com.example.dp_compose_demo.data.models.MovieListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {
    @GET("movies?")
    suspend fun getMovies(
        @Query("page")page: Int
    ): Response<MovieListResponse>

    @GET("movies/{movie_id}")
    suspend fun getDetailsById(
        @Path("movie_id")id: Int
    ):Response<MovieDetails>

    @GET("movies")
    suspend fun getMoviesBySearch(
        @Query("q")movie: String
    ): Response<MovieListResponse>
}