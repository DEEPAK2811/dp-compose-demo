package com.example.dp_compose_demo.network

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class AuthInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {

        val url =
            chain.request().url.newBuilder()
                .addQueryParameter("apikey", "323f1d43")
                .build()

        val newRequest = chain.request().newBuilder().url(url).build()

        return chain.proceed(newRequest)
    }
}