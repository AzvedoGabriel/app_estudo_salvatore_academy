package com.azevedogabriel.appestudo_salvatore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
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
            val mail = mailSend.text.toString()

            if(mail.isBlank()){
             mailSend.error = "Insert your e-mail adress!!"
            }else if(!Patterns.EMAIL_ADDRESS.matcher(mail).matches()){
                mailSend.error = "Please enter a valid e-mail address!"
            }else{
                helloWorld.text = mail
            }
        }
        val  buttonClear = findViewById<Button>(R.id.buttonTwo)

        buttonClear.setOnClickListener {
            helloWorld.text = ""
            mailSend.text = null
        }
    }
}