package com.example.mycoronav.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mycoronav.common.Constants
import com.example.mycoronav.repository.RepositoryImpl
import com.example.mycoronav.vo.Row
import com.example.mycoronav.vo2.Item

class SharedViewModel : ViewModel() {
    //live data
    var rows_live: MutableLiveData<ArrayList<Row>> = MutableLiveData<ArrayList<Row>>()
    //repository
    var repository = RepositoryImpl
    //infinite scroll paging
    private var page = 1

    // 페이지당 item 10개
    fun getRows() {
        repository.getHospitalItem(Constants.START_PAGE)
        repository.onReturn = {
            rows_live.postValue(it)
        }
        page = Constants.START_PAGE
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
//        repository.getItems(page * Constants.START_INDEX, Constants.COUNT_INDEX)
        repository.getHospitalItem(page)
        repository.onReturn = {
            rows_moreLoaded.addAll(it)
        }
        rows_live.postValue(rows_moreLoaded)
        page++
    }
}