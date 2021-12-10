package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.cardView
import com.example.myapplication.constants
import com.example.myapplication.inflate
import java.util.*

class adapter (private var mList: List<cardView>) : RecyclerView.Adapter<adapter.ViewHolder>() {

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



    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        //val imageItem: ImageView = itemView.findViewById(R.id.image)
        val nameItem: TextView = itemView.findViewById(R.id.name)
        val symbolItem: TextView = itemView.findViewById(R.id.symbol)
        val priceItem: TextView = itemView.findViewById(R.id.priceUsdText)
        val volumeItem: TextView = itemView.findViewById(R.id.volume)
        val changeItem: TextView = itemView.findViewById(R.id.change)
    }
}