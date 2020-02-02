package com.inspirecoding.koinexample.adapter

interface RwAdapter<T> {
    fun getData() : List<T>?
    fun insertData(order: T)
}