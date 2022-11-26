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
import com.lutfullayevmuhammad.mydictionary.databinding.ActivityUserBinding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class UserActivity : DaggerAppCompatActivity() {

    private val binding by lazy {
        ActivityUserBinding.inflate(layoutInflater)
    }

    private var adapterUser = UserAdapter()

    @Inject
    lateinit var vmProviderFactory: ViewModelProviderFactory

    private val viewModel: HomeViewModel by viewModels {
        vmProviderFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.userList.adapter = adapterUser
        binding.userList.layoutManager = LinearLayoutManager(this)

        viewModel.userListLiveData.observe(this) {
            adapterUser.setData(it)
        }

        viewModel.getAllData()

        viewModel.alldata.observe(this){
            adapterUser.setData(it!!)
        }

        binding.addBtn.setOnClickListener {
            var userDialog = UserDialog(this)
            userDialog.show()
            userDialog.setOnSaveButtonClick { it1 ->
                viewModel.userListAdd(UserItem(it1))
            }
        }

        adapterUser.onItemClick = {
            viewModel.getAllData()
            viewModel.deleteData(it)
        }

    }

}