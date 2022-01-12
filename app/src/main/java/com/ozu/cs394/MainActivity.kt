package com.ozu.cs394

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cs394.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val userId = intent.getStringArrayExtra("user_id")
        val emailId = intent.getStringArrayExtra("email_id")

        //tv_user.id.text = "USER ID::$userId"
        //tv_email_id.id.text = "USER ID::$emailId"

        btn_logout.setOnClickListener{
            FirebaseAuth.getInstance().signOut()

            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
            finish()
        }
    }



    suspend fun suspendingFunction01() {
        println("Suspending function worked!")
        delay(1000)
    }




}