package com.example.loginshareprefrence

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = findViewById<EditText>(R.id.name)
        val email = findViewById<EditText>(R.id.email)

        val save = findViewById<Button>(R.id.save)
        val show = findViewById<Button>(R.id.show)


        val localStorage = getSharedPreferences("user", Context.MODE_PRIVATE)

        save.setOnClickListener{
            val editPref = localStorage.edit()
            editPref.putBoolean("loginStatus",true)
            editPref.putString("userName",""+name.text.toString())
            editPref.putString("userEmail",""+email.text.toString()).apply()
        }

        show.setOnClickListener{
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }


    }
}