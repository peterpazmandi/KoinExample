package com.inspirecoding.koinexample.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.inspirecoding.koinexample.model.Order
import kotlinx.android.synthetic.main.order_item.view.*
import com.inspirecoding.koinexample.R

private val TAG = "OrderAdapter"
class OrderAdapter(var orderList: MutableList<Order>): RecyclerView.Adapter<OrderAdapter.ViewHolder>(), RwAdapter<Order>
{
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val burger: TextView = itemView.tv_burger
        val drink: TextView = itemView.tv_drink
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        val viewRow = LayoutInflater.from(parent.context).inflate(R.layout.order_item, parent, false)
        return ViewHolder(viewRow)
    }

    override fun getItemCount(): Int = orderList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        Log.d(TAG, orderList[position].burger.name)
        holder.burger.text = orderList[position].burger.name
        holder.drink.text = orderList[position].drink.name
    }

    override fun getData(): List<Order> = orderList

    override fun insertData(order: Order)
    {
        orderList.add(order)
        notifyItemInserted(orderList.lastIndex)
    }
}