package com.example.dp_compose_demo.data.models

data class ApiMetadata(
    val current_page: String,
    val page_count: Int,
    val per_page: Int,
    val total_count: Int
)