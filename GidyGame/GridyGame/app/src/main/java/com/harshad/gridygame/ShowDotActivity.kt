package com.harshad.gridygame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.harshad.gridygame.databinding.ActivityShowDotBinding

class ShowDotActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShowDotBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_show_dot)
        getIntentData()
    }

    private fun getIntentData() {
        val num = intent.getStringExtra("Num")
        Toast.makeText(this,"number : $num",Toast.LENGTH_SHORT).show()
        val gAdapter = GameBoardAdapter(16,num?.toInt()?:0)
        binding.rvBoard.layoutManager = GridLayoutManager(this,4)
        binding.rvBoard.adapter = gAdapter
    }
}