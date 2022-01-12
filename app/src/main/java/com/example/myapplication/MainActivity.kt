package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import kotlinx.coroutines.delay
import okhttp3.OkHttpClient
import okhttp3.Request

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*if(savedInstanceState == null){
            supportFragmentManager.commit {
                setReorderingAllowed(true)
             }
        }*/

        //suspendingFunction01()
    }


    suspend fun suspendingFunction01() {
        println("Suspending function worked!")
        delay(1000)
    }




}