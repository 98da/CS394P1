package com.ozu.cs394

import com.example.cs394.R

class Coins {
    val names : ArrayList<String> = ArrayList<String>()
    val Drawables : ArrayList<Int> = ArrayList<Int>()
    val Symbols : ArrayList<String> = ArrayList<String>()


    internal constructor() {
        names.add("Cardano")
        names.add("Algorant")
        names.add("Binance")
        names.add("Bitcoin")
        names.add("Dogecoin")
        names.add("Alcadot")
        names.add("Ethereum")
        names.add("Link")
        names.add("Litecoin")
        names.add("Solano")
        names.add("Uniswap")
        names.add("Ripple")
        Drawables.add(R.drawable.ada)
        Symbols.add("ada")
        Drawables.add(R.drawable.algo)
        Symbols.add("algo")
        Drawables.add(R.drawable.bnb)
        Symbols.add("bnb")
        Drawables.add(R.drawable.btc)
        Symbols.add("btc")
        Drawables.add(R.drawable.doge)
        Symbols.add("doge")
        Drawables.add(R.drawable.dot)
        Symbols.add("dot")
        Drawables.add(R.drawable.eth)
        Symbols.add("eth")
        Drawables.add(R.drawable.link)
        Symbols.add("link")
        Drawables.add(R.drawable.ltc)
        Symbols.add("ltc")
        Drawables.add(R.drawable.sol)
        Symbols.add("sol")
        Drawables.add(R.drawable.uni)
        Symbols.add("uni")
        Drawables.add(R.drawable.xrp)
        Symbols.add("xrp")

    }

}