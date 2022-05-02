package com.example.data

import javax.inject.Inject

class BeerRemoteSourceImpl @Inject constructor(private val beerApi: BeerApi) : BeerRemoteSource {
    override suspend fun getBeerList(): List<BeerEntity> {
        return beerApi.getBeerList()
    }
}