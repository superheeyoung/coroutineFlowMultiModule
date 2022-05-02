package com.example.data

interface BeerRemoteSource {
    suspend fun getBeerList() : List<BeerEntity>
}