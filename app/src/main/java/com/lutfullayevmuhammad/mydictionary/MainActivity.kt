package com.lutfullayevmuhammad.mydictionary

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import com.lutfullayevmuhammad.mydictionary.core.adapters.details.RecAdapter
import com.lutfullayevmuhammad.mydictionary.core.adapters.home.UserAdapter
import com.lutfullayevmuhammad.mydictionary.core.helper.ViewModelProviderFactory
import com.lutfullayevmuhammad.mydictionary.core.models.dictionaryRec.RecData
import com.lutfullayevmuhammad.mydictionary.core.models.dictionaryUser.UserItem
import com.lutfullayevmuhammad.mydictionary.databinding.ActivityMainBinding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var adapterUser = UserAdapter()
    private var adapterRec = RecAdapter()

    @Inject
    lateinit var vmProviderFactory: ViewModelProviderFactory

    private val viewModel: HomeViewModel by viewModels {
        vmProviderFactory
    }

    var sharedPreferences: SharedPreferences? = null

//    var dao: UserDao? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.userList.adapter = adapterUser
        binding.userList.layoutManager = LinearLayoutManager(this)

        binding.recList.adapter = adapterRec
        binding.recList.layoutManager =
            LinearLayoutManager(this)

        adapterRec.data = recData()

        viewModel.userListLiveData.observe(this) {
            adapterUser.setData(it)
        }

        binding.addBtn.setOnClickListener {
            var userDialog = UserDialog(this)
            userDialog.show()
            userDialog.setOnSaveButtonClick { it1 ->
                viewModel.userListAdd(UserItem(it1))
            }
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

}