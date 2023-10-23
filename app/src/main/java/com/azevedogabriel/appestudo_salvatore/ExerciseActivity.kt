package com.azevedogabriel.appestudo_salvatore

import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class ExerciseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)

        val helloWorld = findViewById<TextView>(R.id.helloWorld)
        val edtName = findViewById<EditText>(R.id.textName)
        val userName = findViewById<TextView>(R.id.userName)
        val emailSend = findViewById<EditText>(R.id.edtMail)
        val buttonSend = findViewById<Button>(R.id.buttonOne)
        val buttonClear = findViewById<Button>(R.id.buttonTwo)


        buttonSend.setOnClickListener {
            val name = edtName.text.toString()
            val mail = emailSend.text.toString()

            if (mail.isBlank()) {
                emailSend.error = "Insert your e-mail adress!!"
            } else if (!Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {
                emailSend.error = "Please enter a valid e-mail address!"
            } else {
                helloWorld.text = mail
                userName.text = name
                Toast.makeText(this, "Success save", Toast.LENGTH_SHORT).show()
            }

        }

        buttonClear.setOnClickListener {
            val oldTextName = userName.text
            val oldTextEditName = edtName.text

            val oldTextEmail = emailSend.text
            val oldTextEmailEdit = helloWorld.text

            userName.text = null
            edtName.text = null

            helloWorld.text = null
            emailSend.text = null


            val constraintLayout = findViewById<View>(R.id.constraintLayout)
            Snackbar.make(constraintLayout, "Cleared successfully", Snackbar.LENGTH_INDEFINITE)
                .setAction("Undo"){
                    userName.text = oldTextName
                    edtName.text = oldTextEditName
                    helloWorld.text = oldTextEmailEdit
                    emailSend.text = oldTextEmail

                    Toast.makeText(this, "undone successfully", Toast.LENGTH_SHORT).show()
                }
                .show()
        }
    }



}