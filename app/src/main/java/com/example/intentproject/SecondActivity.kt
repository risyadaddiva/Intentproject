package com.example.intentproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    val EXTRA_MESSAGE ="com.example.android.twoactivities.extra.MESSAGE"
    val EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY"

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val TEXT_REQUEST = null
        if (requestCode === TEXT_REQUEST) {
            if (resultCode === RESULT_OK) {
                val mReplyHeadTextView =
                    findViewById<TextView>(R.id.text_header_reply)
                val mReplyTextView = findViewById<TextView>(R.id.text_message_reply)
                val reply = data?.getStringExtra(EXTRA_REPLY)
                mReplyHeadTextView.visibility
                mReplyTextView.text = reply
                mReplyTextView.visibility
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val intent =intent
        val message = intent.getStringExtra(EXTRA_MESSAGE)
        val textView = findViewById<TextView>(R.id.text_message)
        textView.text =message

        val mReply = findViewById<EditText>(R.id.editText_second)
        val btnKirimSecond = findViewById<Button>(R.id.button_second)

        btnKirimSecond.setOnClickListener(View.OnClickListener {
            val reply = mReply?.text.toString()
            val replyIntent = Intent()
            replyIntent.putExtra(EXTRA_REPLY, reply)
            setResult(RESULT_OK, replyIntent)
            finish()
        })
    }

}