package com.example.mycoronav.network

import com.example.mycoronav.vo.ResponseData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {
    @GET("{KEY}/{TYPE}/{SERVICE}/{START_INDEX}/{END_INDEX}")
    fun getCoronaList(
        @Path("KEY", encoded = true) KEY : String,
        @Path("TYPE", encoded = true) TYPE : String,
        @Path("SERVICE", encoded = true) SERVICE : String,
        @Path("START_INDEX", encoded = true) START_INDEX : Int,
        @Path("END_INDEX", encoded = true) END_INDEX : Int
    ): Call <ResponseData>
}