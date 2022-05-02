package com.example.domain

import com.example.data.BeerEntity
import com.example.data.BeerRemoteSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class BeerRepositoryImpl @Inject constructor(private val getBeerRemoteSource: BeerRemoteSource) : BeerRepository{
    override fun getBeerList(): Flow<List<BeerEntity>> {
        return flow {
            emit(getBeerRemoteSource.getBeerList())
        }.flowOn(Dispatchers.IO)
    }

}