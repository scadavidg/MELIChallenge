package com.melichallenge.di

import com.melichallenge.data.services.ItemsService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import java.util.concurrent.TimeUnit.SECONDS

private const val TIME_OUT = 30L

val dataModule = module {
    // Client
    single {
        OkHttpClient
            .Builder()
            .connectTimeout(TIME_OUT, SECONDS)
            .readTimeout(TIME_OUT, SECONDS)
            .build()
    }

    // services
    single { ItemsService() }
}
