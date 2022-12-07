package com.tia.orwma_lv7


import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Query
import kotlin.String

interface MakeupEndpoints {
    @GET("/api/v1/products.json?")
    fun getMakeup(@Query("brand")brand: String):Call<ArrayList<Makeup>>
}






