package com.lutfullayevmuhammad.mydictionary.service

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.lutfullayevmuhammad.mydictionary.databinding.ActivityServiceBinding

class ServiceActivity : AppCompatActivity() {

    private val binding: ActivityServiceBinding by lazy {
        ActivityServiceBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        val intent = Intent(this, MyBackgroundService::class.java)
        binding.statService.setOnClickListener {
            val intent = Intent(this, MyForegroundService::class.java)
            intent.putExtra("state",true)

            ContextCompat.startForegroundService(this,intent)
        }

        binding.stopService.setOnClickListener {
            val intent = Intent(this, MyForegroundService::class.java)
            intent.putExtra("state",false)
            stopService(intent)
        }

    }


}