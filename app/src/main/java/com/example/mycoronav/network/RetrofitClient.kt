package com.example.mycoronav.network

import android.util.Log
import com.example.mycoronav.common.Constants
import com.google.gson.GsonBuilder
import com.tickaroo.tikxml.TikXml
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

//import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private var instance : Retrofit?= null
    private var gson = GsonBuilder().setLenient().create()
    //singleton
    fun getInstance() : Retrofit{
        if(instance == null){
            instance = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
        }
        return instance!!
    }

    fun getXMLInstance() : Retrofit{
        val logger = HttpLoggingInterceptor{
            Log.d("API", it)
        }
        logger.level = HttpLoggingInterceptor.Level.BASIC

        val client = OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()

        val parser = TikXml.Builder().exceptionOnUnreadXml(false).build()

//        if(instance == null){
//            instance = Retrofit.Builder()
            return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(client)
                .addConverterFactory(TikXmlConverterFactory.create(parser))
                .build()

//        }
//        return instance!!
    }
}