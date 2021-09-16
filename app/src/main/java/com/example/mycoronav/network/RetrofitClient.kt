package com.example.mycoronav.network

import com.example.mycoronav.common.Constants
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private var instance : Retrofit?= null
    private var gson = GsonBuilder().setLenient().create()
    //singleton
    fun getInstance() : Retrofit{
        if(instance == null){
            instance = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }
        return instance!!
    }
}