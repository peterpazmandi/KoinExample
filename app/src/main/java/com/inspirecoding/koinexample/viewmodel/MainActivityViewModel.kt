package com.inspirecoding.koinexample.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.inspirecoding.koinexample.model.Order

private const val TAG = "MainActivityViewModel"
class MainActivityViewModel: ViewModel()
{
    private val listOrders = mutableListOf<Order>()
    val listOrdersLD = MutableLiveData<MutableList<Order>>()

    fun insertOrder(order: Order)
    {
        listOrders.add(order)
        Log.d(TAG, "$listOrders")

        listOrdersLD.postValue(listOrders)
    }
}