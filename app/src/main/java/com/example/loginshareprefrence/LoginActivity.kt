package com.example.loginshareprefrence

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val localStorage = getSharedPreferences("user", Context.MODE_PRIVATE)

        val getName = localStorage.getString("userName","Name Not Found")
        val getEmail = localStorage.getString("userEmail","Email Not Found")

        val textname = findViewById<TextView>(R.id.textname)
        val textemail = findViewById<TextView>(R.id.textemail)
        val logout = findViewById<Button>(R.id.logout)

        textname.text=getName.toString()
        textemail.text=getEmail.toString()

        Toast.makeText(this,"$getName", Toast.LENGTH_SHORT).show()
        Toast.makeText(this,"$getEmail", Toast.LENGTH_SHORT).show()

        logout.setOnClickListener{
            localStorage.edit().clear().apply()
            Toast.makeText(this,"Logout",Toast.LENGTH_SHORT).show()
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}