package com.example.mycoronav.repository

import com.example.mycoronav.vo.Row

interface Repository {
    fun getItems(startIndex: Int, count: Int)
    fun deleteRow(row: Row): ArrayList<Row>
}