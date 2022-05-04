package com.nicootech.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.nicootech.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding :ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        findViewById<Button>(R.id.done_button).setOnClickListener {
//            addNickname(it)
//        }
        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {
//        val nicknameEditText = findViewById<EditText>(R.id.nickname_editText)
//        val nicknameTextView = findViewById<TextView>(R.id.nickname_textView)

//        nicknameTextView.text = nicknameEditText.text
//        //edit text will be hidden
//        nicknameEditText.visibility = View.GONE
//        //button will be hidden
//        view.visibility = View.GONE
//        nicknameTextView.visibility = View.VISIBLE
        binding.apply {
            nicknameTextView.text = binding.nicknameEditText.text
            invalidateAll()
            nicknameEditText.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameEditText.visibility = View.VISIBLE
            bioScroll.visibility = View.VISIBLE
        }


        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}