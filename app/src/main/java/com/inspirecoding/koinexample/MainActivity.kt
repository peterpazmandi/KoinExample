package com.inspirecoding.koinexample

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.inspirecoding.koinexample.adapter.OrderAdapter
import com.inspirecoding.koinexample.model.Order
import com.inspirecoding.koinexample.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity()
{
    private var listOrders = mutableListOf<Order>()

    private val mainActivityViewModel by lazy {
        ViewModelProvider(this).get(MainActivityViewModel::class.java)
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var orderAdapter: OrderAdapter
    private lateinit var layoutManager: RecyclerView.LayoutManager


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buildRecyclerView(listOrders)

        mainActivityViewModel.listOrdersLD.observe(this, Observer { listOfOrder ->
            listOrders.add(listOfOrder[listOfOrder.lastIndex])
            orderAdapter.notifyItemInserted(listOrders.lastIndex)
        })

        btn_order.setOnClickListener {
            if(nullAndEmptyChecker())
            {
                mainActivityViewModel.insertOrder(
                    et_nameGuest.text.toString(),
                    et_burger.text.toString(),
                    tv_drink.text.toString()
                )
                clearFields()
                hideSoftKeyboard()
            }
        }
    }

    private fun buildRecyclerView(listOfOrder: MutableList<Order>?)
    {
        recyclerView = findViewById(R.id.rv_listOfOrders)
        recyclerView.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        orderAdapter = OrderAdapter(listOfOrder)

        recyclerView.also {
            recyclerView.layoutManager = this.layoutManager
            recyclerView.adapter = orderAdapter
        }
    }

    private fun hideSoftKeyboard()
    {
        val inputMethodManager: InputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
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

    private fun clearFields()
    {
        et_nameGuest.text.clear()
        et_burger.text.clear()
    }
}
