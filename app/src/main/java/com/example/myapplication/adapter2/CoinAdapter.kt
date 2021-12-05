package com.example.myapplication.adapter2


import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Model.CoinModel
import com.example.myapplication.R
import com.example.myapplication.common2.Common
import com.example.myapplication.interface2.ILoadMore
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.coin_layout.view.*
import java.util.*

class CoinViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var coinIcon: ImageView = itemView.coinIcon
    var coinSymbol: TextView = itemView.coinSymbol
    var coinName: TextView = itemView.coinName
    var coinPrice: TextView = itemView.priceUsd
    var oneHourChange: TextView = itemView.oneHour
    var twentyFourChange: TextView = itemView.twentyFourHour
    var sevenDayChange: TextView = itemView.sevenDay
}

class CoinAdapter(recyclerView: RecyclerView, private var activity: Activity, private var items: List<CoinModel>) : RecyclerView.Adapter<CoinViewHolder>() {

    internal var loadMore: ILoadMore? = null
    var isLoading: Boolean = false
    var visibleThreshold = 5
    var lastVisibleItem: Int = 0
    var totalItemCount: Int = 0

    init {
        val linearLayout = recyclerView.layoutManager as LinearLayoutManager
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                totalItemCount = linearLayout.itemCount
                lastVisibleItem = linearLayout.findLastVisibleItemPosition()
                if (!isLoading && totalItemCount <= lastVisibleItem + visibleThreshold) {
                    if (loadMore != null)
                        loadMore!!.onLoadMore()
                    isLoading = true
                }
            }
        })
    }

    fun setLoadMore(loadMore: ILoadMore) {
        this.loadMore = loadMore
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val view = LayoutInflater.from(activity)
            .inflate(R.layout.coin_layout, parent, false)
        return CoinViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(
        holder: CoinViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        val coinModel = items[position]

        holder.coinName.text = coinModel.name
        holder.coinSymbol.text = coinModel.symbol
        holder.coinPrice.text = coinModel.price_usd
        holder.oneHourChange.text = coinModel.percent_change_1h + "%"
        holder.twentyFourChange.text = coinModel.percent_change_24h + "%"
        holder.sevenDayChange.text = coinModel.percent_change_7d + "%"

        Picasso.with(activity.baseContext)
            .load(
                StringBuilder(Common.imageUrl)
                    .append(coinModel.symbol!!.lowercase(Locale.getDefault()))
                    .append(".png")
                    .toString()
            )
            .into(holder.coinIcon)

        //Set color
        holder.oneHourChange.setTextColor(
            if (coinModel.percent_change_1h!!.contains("-"))
                Color.parseColor("#FF0000")
            else
                Color.parseColor("#32CD32")
        )

        holder.twentyFourChange.setTextColor(
            if (coinModel.percent_change_24h!!.contains("-"))
                Color.parseColor("#FF0000")
            else
                Color.parseColor("#32CD32")
        )

        holder.sevenDayChange.setTextColor(
            if (coinModel.percent_change_7d!!.contains("-"))
                Color.parseColor("#FF0000")
            else
                Color.parseColor("#32CD32")
        )

    }

    fun  setLoaded(){
        isLoading = false
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(coinModels: List<CoinModel>)
    {
        this.items = coinModels
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}