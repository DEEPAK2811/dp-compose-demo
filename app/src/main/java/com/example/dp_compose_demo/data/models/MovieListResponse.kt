package com.example.dp_compose_demo.data.models

data class MovieListResponse(
    val data: List<MovieData>,
    val metadata: ApiMetadata
)