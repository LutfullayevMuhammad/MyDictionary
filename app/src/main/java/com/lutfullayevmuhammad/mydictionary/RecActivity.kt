package com.lutfullayevmuhammad.mydictionary

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.lutfullayevmuhammad.mydictionary.core.adapters.details.RecAdapter
import com.lutfullayevmuhammad.mydictionary.core.models.dictionaryRec.RecData
import com.lutfullayevmuhammad.mydictionary.databinding.ActivityRecBinding
import com.lutfullayevmuhammad.mydictionary.service.MyBroadcastReciver
import dagger.android.support.DaggerAppCompatActivity

class RecActivity : DaggerAppCompatActivity() {

    private val binding by lazy {
        ActivityRecBinding.inflate(layoutInflater)
    }

    private var adapterRec = RecAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.recList.adapter = adapterRec
        binding.recList.layoutManager =
            LinearLayoutManager(this)

        adapterRec.data = recData()

        binding.startNotification.setOnClickListener {
            canExactAlarmsBeScheduled()
            val myIntent = Intent(this, MyBroadcastReciver::class.java)
            myIntent.putExtra("translation", recData().random().dictionary)
            val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
            val pendingIntent = PendingIntent.getBroadcast(this, 0, myIntent, 0)
            alarmManager.setRepeating(
                AlarmManager.RTC_WAKEUP, System.currentTimeMillis(),
                7200000.toLong(),
                pendingIntent
            )
            Toast.makeText(this,"Start Notification",Toast.LENGTH_SHORT).show()
        }
    }

    fun recData(): ArrayList<RecData> {
        return arrayListOf(
            RecData("adjective - sifat"),
            RecData("adverb - ravish"),
            RecData("attributive - aniqlovchi"),
            RecData("conjunction - bog 'lovchi"),
            RecData("emphatic - kuchaytiruvchi"),
            RecData("imperative - buyruq mayli"),
            RecData("indefinite - gumon"),
            RecData("infinitive - infinitiv"),
            RecData("interjection - undov"),
            RecData("noun - ot"),
            RecData("numeral cardinal - sanoq son"),
            RecData("numeral ordinal - tartib son"),
            RecData("of past perfect of - ... ning o'tgan zamon sifatdosh shakli"),
            RecData("particle - yuklama"),
            RecData("passive - majhul nisbat"),
            RecData("past of past of - ... ning o'tgan zamon shakli"),
            RecData("plural - ko 'plik"),
            RecData("predicative - qo'shma kesimning ot qismi"),
            RecData("prefiks - prefiks"),
            RecData("preposition - predlog"),
            RecData("present participle - hozirgi zamon sifatdoshi"),
            RecData("pronoun - olmosh"),
            RecData("conjunctive pronoun - bog'lovchi olmosh"),
            RecData("definite pronoun - belgilash olmoshi"),
            RecData("demonstrative pronoun - ko'rsatish olmoshi"),
            RecData("indefinite pronoun - gum on olmoshi"),
            RecData("negative pronoun - bo'lishsizlik olmoshi"),
            RecData("personal pronoun - kishilik olmoshi"),
            RecData("possessive pronoun - egalik olmoshi"),
            RecData("retlexive pronoun - o'zlik olmoshi"),
            RecData("singular - birlik shakl"),
            RecData("somebody - biror kimsa"),
            RecData("something - biror narsa"),
            RecData("slang - jargon"),
            RecData("verb - fe'l"),
            RecData("are - bor"),
            RecData("alright - yaxshi"),
            RecData("about - haqida"),
            RecData("above - yuqorida"),
            RecData("absolutely - mutlaqo"),
            RecData("ability - qobiliyat"),
            RecData("actually - aslida"),
            RecData("accept - qabul qilish"),
            RecData("account - hisob"),
            RecData("aqua - suv"),
            RecData("aquarium - akvarium"),
            RecData("aquarius - paqir"),
            RecData("azure - jozibali"),
            RecData("axe - bolta"),
            RecData("axis - o'qi"),
            RecData("awesome - ajoyib"),
            RecData("away - uzoqda"),
            RecData("awful - dahshatli"),
            RecData("awkward - noqulay"),
            RecData("aesthetic - estetik"),
            RecData("aeroplane - samolyot"),
            RecData("removed - olib tashlandi"),
            RecData("re - qayta"),
            RecData("really - haqiqatan ham"),
            RecData("rough - qo'pol")
        )
    }


    private fun canExactAlarmsBeScheduled(): Boolean {
        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            alarmManager.canScheduleExactAlarms()
        } else {
            true
        }
    }

}