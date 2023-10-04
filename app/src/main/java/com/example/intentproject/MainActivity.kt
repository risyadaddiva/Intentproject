package com.example.intentproject

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private val LOG_TAG = MainActivity::class.java.simpleName
    val EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mMessageEditText =findViewById<EditText>(R.id.editText_main)
        val btnkirim = findViewById<Button>(R.id.button_main)


        btnkirim.setOnClickListener(View.OnClickListener {
            Log.d(LOG_TAG, "Button clicked")
            val intent =Intent(this, SecondActivity::class.java)
            val message = mMessageEditText.text.toString()
            Log.d(LOG_TAG, message)
            intent.putExtra(EXTRA_MESSAGE, message)
            startActivity(intent)
        })
    }

    fun launchSecondActivity(view: View) {
        Log.d(LOG_TAG, "Button clicked!")
    }
}