package com.example.loginshareprefrence

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val localStorage = getSharedPreferences("user", Context.MODE_PRIVATE)
        val isLogin = localStorage.getBoolean("loginStatus",false)

        Handler().postDelayed({
            if (isLogin==true){
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)

            }
            else{
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            finish()

        },3000)

    }
}