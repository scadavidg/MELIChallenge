package com.melichallenge.data.services

import com.example.melichallenge.BuildConfig.API_URL
import com.google.gson.JsonArray
import com.melichallenge.utils.API_SEARCH_BY_ID_ENDPOINT
import com.melichallenge.utils.API_SEARCH_BY_ID_ENDPOINT_QUERY_KEY
import com.melichallenge.utils.API_SEARCH_ENDPOINT
import com.melichallenge.utils.API_SEARCH_ENDPOINT_QUERY_KEY
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET(API_SEARCH_ENDPOINT)
    fun searchItems(@Query(API_SEARCH_ENDPOINT_QUERY_KEY) searchText: String): Call<JsonArray>

    @GET(API_SEARCH_BY_ID_ENDPOINT)
    fun searchItem(@Query(API_SEARCH_BY_ID_ENDPOINT_QUERY_KEY) id: String): Call<JsonArray>

    companion object {
        operator fun invoke(): APIService {
            val authInterceptor = Interceptor { chain ->
                val url = chain.request().url.newBuilder()
                    .addQueryParameter("format", "json")
                    .build()

                val newRequest = chain.request()
                    .newBuilder()
                    .header("Content-Type", "application/json")
                    .url(url)
                    .build()

                chain.proceed(newRequest)
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(authInterceptor).build()

            val retrofit = Retrofit.Builder()
                .baseUrl(API_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(APIService::class.java)
        }
    }
}
