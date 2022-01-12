package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class mainPage : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fragment(R.layout.fragment_main_page)
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        //ArrayList of class ItemsViewModel
        val data = ArrayList<cardView>()

        // This loop will create 20 Views containing
        // the image with the count of view
        for (i in 1..20) {
            data.add(cardView(R.drawable.btc, "Item " + i,"Item " + i,"Item " + i,"Item " + i,"Item " + i))
        }

        val adapter = myAdapter(data)


        recyclerview.adapter = adapter

    }
}

class recycler() : Fragment(R.layout.recycler) {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.recycler, container, false)

        return view
    }
}

class myAdapter (private var mList: List<cardView>) : RecyclerView.Adapter<myAdapter.ViewHolder>() {
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        //val imageItem: ImageView = itemView.findViewById(R.id.image)
        val nameItem: TextView = itemView.findViewById(R.id.name)
        val symbolItem: TextView = itemView.findViewById(R.id.symbol)
        val priceItem: TextView = itemView.findViewById(R.id.priceUsdText)
        val volumeItem: TextView = itemView.findViewById(R.id.volume)
        val changeItem: TextView = itemView.findViewById(R.id.change)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val cardViewModel = mList[position]

        // holder.imageItem.setImageResource(cardViewModel.pri)
        holder.nameItem.text = cardViewModel.name
        holder.symbolItem.text = cardViewModel.symbol
        holder.priceItem.text = cardViewModel.price
        holder.volumeItem.text = cardViewModel.volume
        holder.changeItem.text = cardViewModel.change
    }

    override fun getItemCount(): Int = mList.count()




}