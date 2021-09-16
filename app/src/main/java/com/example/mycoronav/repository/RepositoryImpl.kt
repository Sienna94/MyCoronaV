package com.example.mycoronav.repository

import android.app.Application
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import com.example.mycoronav.common.Constants
import com.example.mycoronav.network.RetrofitClient
import com.example.mycoronav.network.RetrofitService
import com.example.mycoronav.viewmodel.SharedViewModel
import com.example.mycoronav.vo.ResponseData
import com.example.mycoronav.vo.Row
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//singleton
object RepositoryImpl : Repository {
    private val retrofit = RetrofitClient.getInstance()
    var rows: ArrayList<Row> = ArrayList()
    val retrofitService = retrofit.create(RetrofitService::class.java)
    var onReturn: ((ArrayList<Row>) -> Unit)? = null

    override fun getItems(startIndex: Int, count: Int) {
        //create retrofit instance
        //request data from API
        rows.clear()
        retrofitService.getCoronaList(
            Constants.KEY,
            Constants.TYPE,
            Constants.SERVICE,
            startIndex,
            (startIndex + count) - 1
        )
            .enqueue(object : Callback<ResponseData> {
                override fun onResponse(
                    call: Call<ResponseData>,
                    response: Response<ResponseData>
                ) {
                    if (response.isSuccessful) {
                        Log.d("ddd", "response.code = ${response.code()}")
                        Log.d("ddd", "response.message = ${response.message()}")
                        response.body()?.let {
                            for (row in it.corona19Status.row) {
                                rows.add(row)
                            }
                            onReturn?.invoke(rows)
                        }
                    } else {
                        Log.d("ddd", "onResponse: notSuccessful")
                    }
                }

                override fun onFailure(call: Call<ResponseData>, t: Throwable) {
                    Log.d("ddd", "onFailure: t = ${t.message}")
                }
            })
    }

    override fun deleteRow(row: Row): ArrayList<Row> {
        var rowsDeletedData: ArrayList<Row>
        rows.run {
            this.remove(row)
            rowsDeletedData = this
            rows = rowsDeletedData
        }
        return rows
    }
}