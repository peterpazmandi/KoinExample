package com.inspirecoding.koinexample.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.inspirecoding.koinexample.model.Burger
import com.inspirecoding.koinexample.model.Drink
import com.inspirecoding.koinexample.model.Guest
import com.inspirecoding.koinexample.model.Order

private const val TAG = "MainActivityViewModel"
class MainActivityViewModel: ViewModel()
{
    private lateinit var burger: Burger
    private lateinit var drink: Drink
    private lateinit var guest: Guest
    private lateinit var order: Order

    private val listOrders = mutableListOf<Order>()
    val listOrdersLD = MutableLiveData<MutableList<Order>>()

    fun insertOrder(guest: String, burger: String, drink: String = "")
    {
        this.burger = Burger(burger)
        this.drink = Drink()
        this.guest = Guest(guest)
        order = Order(
            burger = this.burger,
            drink = this.drink,
            guest = this.guest)
        listOrders.add(order)
        Log.d(TAG, "$listOrders")

        listOrdersLD.postValue(listOrders)
    }
}