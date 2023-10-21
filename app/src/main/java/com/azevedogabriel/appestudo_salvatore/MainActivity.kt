package com.azevedogabriel.appestudo_salvatore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonSend = findViewById<Button>(R.id.buttonOne)
        val helloWorld = findViewById<TextView>(R.id.helloWorld)
        val mailSend = findViewById<EditText>(R.id.edtMail)

        buttonSend.setOnClickListener {
            helloWorld.text = mailSend.text
        }
    }
}