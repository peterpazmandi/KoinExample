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
class OrderAdapter(var orderList: MutableList<Order>?): RecyclerView.Adapter<OrderAdapter.ViewHolder>(), RwAdapter<Order>
{
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val guestName: TextView = itemView.tv_nameGuest
        val burger: TextView = itemView.tv_burger
        val drink: TextView = itemView.tv_drink
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        val viewRow = LayoutInflater.from(parent.context).inflate(R.layout.order_item, parent, false)
        return ViewHolder(viewRow)
    }

    override fun getItemCount(): Int = orderList?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        orderList?.let {list ->
            Log.d(TAG, list[position].burger.name)
            holder.guestName.text = list[position].guest.name
            holder.burger.text = list[position].burger.name
            holder.drink.text = list[position].drink.name
        }
    }

    override fun getData(): List<Order>? = orderList

    override fun insertData(order: Order)
    {
        orderList?.let {
            it.add(order)
            notifyItemInserted(it.lastIndex)
        }
    }
}