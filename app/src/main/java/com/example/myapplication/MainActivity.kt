package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.Model.CoinModel
import com.example.myapplication.adapter2.CoinAdapter
import com.example.myapplication.common2.Common
import com.example.myapplication.interface2.ILoadMore
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity() : AppCompatActivity(), ILoadMore, Parcelable {
    internal var items:MutableList<CoinModel> = ArrayList()
    internal  lateinit var adapter: CoinAdapter
    private lateinit var client: OkHttpClient
    private lateinit var request: Request

    constructor(parcel: Parcel) : this() {

    }


    override fun onLoadMore() {
        if(items.size <= Common.MAX_COIN_LOAD)
            loadNext10Coin(items.size)
        else
            Toast.makeText(this@MainActivity,"Data max is "+Common.MAX_COIN_LOAD,Toast.LENGTH_SHORT)
                .show()
    }

    private fun loadNext10Coin(index: Int) {
        client = OkHttpClient()
        request = Request.Builder()
            .url(String.format("https://api.coinmarketcap.com/v1/ticker/?start=%d&limit=10",index))
            .build()

        swipe_to_refresh.isRefreshing=true // SHow refresh
        client.newCall(request)
            .enqueue(object : Callback
            {
                override fun onFailure(call: Call?, e: IOException?) {
                    Log.d("ERROR",e.toString())
                }

                override fun onResponse(call: Call?, response: Response) {
                    val body = response.body()!!.string()
                    val gson=Gson()
                    val newItems = gson.fromJson<List<CoinModel>>(body,object:TypeToken<List<CoinModel>>(){}.type)
                    runOnUiThread {
                        items.addAll(newItems)
                        adapter.setLoaded()
                        adapter.updateData(items)

                        swipe_to_refresh.isRefreshing=false
                    }
                }
            })

    }

    private fun loadFirst10Coin() {
        client = OkHttpClient()
        request = Request.Builder()
            .url(String.format("https://api.coinmarketcap.com/v1/ticker/?start=0&limit=10"))
            .build()


        client.newCall(request)
            .enqueue(object :Callback
            {
                override fun onFailure(call: Call?, e: IOException?) {
                    Log.d("ERROR",e.toString())
                }

                override fun onResponse(call: Call?, response: Response) {
                    val body = response.body()!!.string()
                    val gson=Gson()
                    items = gson.fromJson(body,object:TypeToken<List<CoinModel>>(){}.type)
                    runOnUiThread {
                        adapter.updateData(items)


                    }
                }
            })

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        swipe_to_refresh.post { loadFirst10Coin() }

        swipe_to_refresh.setOnRefreshListener {
            items.clear() // Remove all item
            loadFirst10Coin()
            setUpAdapter()
        }

        coin_recycler_view.layoutManager = LinearLayoutManager(this)
        setUpAdapter()
    }

    private fun setUpAdapter() {
        adapter = CoinAdapter(coin_recycler_view,this@MainActivity,items)
        coin_recycler_view.adapter = adapter
        adapter.setLoadMore(this)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }
}
