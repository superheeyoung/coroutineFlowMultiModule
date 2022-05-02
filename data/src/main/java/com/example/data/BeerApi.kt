package com.example.data


import retrofit2.http.GET
import retrofit2.http.Query


interface BeerApi {
    @GET("beers")
    suspend fun getBeerList(
        @Query("page")page : Int = 0,
        @Query("per_page")per_page : Int = 30 ) : List<BeerEntity>
}