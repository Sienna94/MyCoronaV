package com.example.mycoronav.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mycoronav.common.Constants
import com.example.mycoronav.repository.RepositoryImpl
import com.example.mycoronav.vo.Row

class SharedViewModel : ViewModel() {
    //live data
    var rows_live: MutableLiveData<ArrayList<Row>> = MutableLiveData<ArrayList<Row>>()

    //repository
    var repository = RepositoryImpl

    //infinite scroll paging
    private var page = 1

    fun getRows() {
        repository.getItems(Constants.START_INDEX, Constants.COUNT_INDEX)
        repository.onReturn = {
            rows_live.postValue(it)
        }
        page = 1
    }

    fun deleteRow(row: Row) {
        val rows_deleted = repository.deleteRow(row)
        rows_live.postValue(rows_deleted)
    }

    fun loadMore() {
        val rows_moreLoaded = ArrayList<Row>()
        rows_live.value.let {
            rows_moreLoaded.addAll(it!!)
        }
        repository.getItems(page * Constants.START_INDEX, Constants.COUNT_INDEX)
        repository.onReturn = {
            rows_moreLoaded.addAll(it)
        }
        rows_live.postValue(rows_moreLoaded)
        page++
    }
}