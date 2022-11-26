package com.lutfullayevmuhammad.mydictionary

import android.app.AlarmManager
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatDelegate
import com.lutfullayevmuhammad.mydictionary.core.adapters.details.RecAdapter
import com.lutfullayevmuhammad.mydictionary.core.adapters.home.UserAdapter
import com.lutfullayevmuhammad.mydictionary.core.helper.ViewModelProviderFactory
import com.lutfullayevmuhammad.mydictionary.core.models.dictionaryRec.RecData
import com.lutfullayevmuhammad.mydictionary.databinding.ActivityMainBinding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    var sharedPreferences: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recBtn.setOnClickListener {
            var intent = Intent(this, RecActivity::class.java)
            startActivity(intent)
        }

        binding.userBtn.setOnClickListener {
            var intent = Intent(this, UserActivity::class.java)
            startActivity(intent)
        }

        sharedPreferences = getSharedPreferences("night", Context.MODE_PRIVATE)
        val dayNight: Boolean = sharedPreferences?.getBoolean("night_mode", true)!!
        if (dayNight) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            binding.dayNightBtn.isChecked = true
        }
        binding.dayNightBtn.setOnCheckedChangeListener { compoundButton, b ->
            if (b) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                binding.dayNightBtn.isChecked = true
                var editor: SharedPreferences.Editor = sharedPreferences!!.edit()
                editor.putBoolean("night_mode", true)
                editor.commit()


            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                binding.dayNightBtn.isChecked = false
                var editor: SharedPreferences.Editor = sharedPreferences!!.edit()
                editor.putBoolean("night_mode", false)
                editor.commit()
            }
        }
    }

}