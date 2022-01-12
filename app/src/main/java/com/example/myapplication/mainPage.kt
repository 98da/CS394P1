package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class mainPage : Fragment(R.layout.fragment_main_page){


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) : View? {
        val view = inflater.inflate(R.layout.fragment_main_page, container, false)
        val coinler=Coins()
        val data = ArrayList<cardView>()

        for (i in 1..11) {
            data.add(cardView(coinler.Drawables.get(i), coinler.names.get(i),coinler.Symbols.get(i),"Item " + i,"Item " + i,"Item " + i))
        }

        val adapterView = myAdapter(data)

        view.findViewById<RecyclerView>(R.id.recyclerviewX).run{
            adapter = adapterView
        }

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

data class cardView(val image: Int, val name: String, val symbol: String, val price: String, val volume: String, val change: String) {
        
}

class list
{

}