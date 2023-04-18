package com.harshad.gridygame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.harshad.gridygame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initView()
    }

    private fun initView() {
        val number = binding.etvNumber.text.toString()
        binding.btnStart.setOnClickListener {
            if (number.isNotEmpty()) {
                val showDot = Intent(this, ShowDotActivity::class.java)
                showDot.putExtra("Num", number)
                startActivity(showDot)
            } else {
                Toast.makeText(this, "please enter number $number", Toast.LENGTH_SHORT).show()
            }
        }
    }
}