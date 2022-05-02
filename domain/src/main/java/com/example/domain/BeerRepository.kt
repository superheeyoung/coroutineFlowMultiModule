package com.example.domain

import com.example.data.BeerEntity
import kotlinx.coroutines.flow.Flow

interface BeerRepository {
    fun getBeerList() : Flow<List<BeerEntity>>
}