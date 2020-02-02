package com.inspirecoding.koinexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.inspirecoding.koinexample.adapter.OrderAdapter
import com.inspirecoding.koinexample.model.Burger
import com.inspirecoding.koinexample.model.Drink
import com.inspirecoding.koinexample.model.Guest
import com.inspirecoding.koinexample.model.Order
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{
    private lateinit var burger: Burger
    private lateinit var drink: Drink
    private lateinit var guest: Guest
    private lateinit var order: Order

    private val listOrders = mutableListOf<Order>()

    private lateinit var recyclerView: RecyclerView
    private lateinit var orderAdapter: OrderAdapter
    private lateinit var layoutManager: RecyclerView.LayoutManager


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createExampleList()
        buildRecyclerView()

        btn_order.setOnClickListener {
            if(nullAndEmptyChecker())
            {
                insertOrder()
                clearFields()
            }
        }
    }

    private fun clearFields()
    {
        et_nameGuest.text.clear()
        et_burger.text.clear()
    }

    private fun nullAndEmptyChecker(): Boolean
    {
        if (et_nameGuest.text.isNullOrEmpty())
        {
            Toast.makeText(this, "Your name is empty", Toast.LENGTH_SHORT).show()
            return false
        }
        if (et_burger.text.isNullOrEmpty())
        {
            Toast.makeText(this, "Your burger is empty", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    private fun insertOrder()
    {
        burger = Burger(et_burger.text.toString())
        drink = Drink()
        guest = Guest(et_nameGuest.text.toString())
        order = Order(
            burger = burger,
            drink = drink,
            guest = guest)
        listOrders.add(order)

        orderAdapter.notifyItemInserted(listOrders.lastIndex)
    }

    private fun createExampleList()
    {
        burger = Burger("Street Burger")
        drink = Drink()
        guest = Guest("Inspire Coding")
        order = Order(
            burger = burger,
            drink = drink,
            guest = guest)
        listOrders.add(order)

        burger = Burger("Smokey BBQ")
        drink = Drink()
        guest = Guest("Peter")
        order = Order(
            burger = burger,
            drink = drink,
            guest = guest)
        listOrders.add(order)

        burger = Burger("Guitar Hero")
        drink = Drink()
        guest = Guest("Viktoria")
        order = Order(
            burger = burger,
            drink = drink,
            guest = guest)
        listOrders.add(order)
    }

    private fun buildRecyclerView()
    {
        recyclerView = findViewById(R.id.rv_listOfOrders)
        recyclerView.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        orderAdapter = OrderAdapter(listOrders)

        recyclerView.also {
            recyclerView.layoutManager = this.layoutManager
            recyclerView.adapter = orderAdapter
        }
    }
}
