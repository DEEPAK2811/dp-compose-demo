package com.example.dp_compose_demo.data.paging

interface Pagination<Key, Item> {
    suspend fun loadNextPage()
    fun reset()
}