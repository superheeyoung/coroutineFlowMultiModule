package com.example.sampleflowkotlin.di

import com.example.data.BeerApi
import com.example.data.BeerRemoteSource
import com.example.data.BeerRemoteSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import okhttp3.logging.HttpLoggingInterceptor


@Module
@InstallIn(ApplicationComponent::class)
class RemoteSourceModule {
    @Provides
    @Singleton
    fun provideBerRemoteSource(
        beerApi: BeerApi = providerRetrofitBuilder()
    ): BeerRemoteSource = BeerRemoteSourceImpl(beerApi)

    @Provides
    @Singleton
    fun providerRetrofitBuilder(): BeerApi {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(interceptor)
            .build()
        return Retrofit.Builder().baseUrl("https://api.punkapi.com/v2/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BeerApi::class.java)
    }
}