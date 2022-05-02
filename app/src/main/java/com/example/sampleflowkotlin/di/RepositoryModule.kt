package com.example.sampleflowkotlin.di

import com.example.data.BeerRemoteSource
import com.example.domain.BeerRepository
import com.example.domain.BeerRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class RepositoryModule {
    //TODO binds vs provides
    @Binds
    @Singleton
    fun providesBeerRepository(beerRemoteSource: BeerRemoteSource) : BeerRepository = BeerRepositoryImpl(beerRemoteSource)
}