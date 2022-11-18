package com.lutfullayevmuhammad.mydictionaryimport android.util.Logimport androidx.lifecycle.MutableLiveDataimport androidx.lifecycle.ViewModelimport com.lutfullayevmuhammad.mydictionary.core.models.dictionaryRec.RecDataimport com.lutfullayevmuhammad.mydictionary.core.models.dictionaryUser.UserDaoimport com.lutfullayevmuhammad.mydictionary.core.models.dictionaryUser.UserItemimport kotlinx.coroutines.CoroutineScopeimport kotlinx.coroutines.Dispatchersimport kotlinx.coroutines.launchimport javax.inject.Injectclass HomeViewModel @Inject constructor(var itemDao: UserDao) : ViewModel() {    var userListLiveData = MutableLiveData<List<UserItem>>()    fun userListAdd(userItem: UserItem) {        CoroutineScope(Dispatchers.IO).launch {            try {                itemDao.insert(userItem)                val response = itemDao.getAllUsers()                userListLiveData.postValue(response)            } catch (e: java.lang.Exception) {                print("##error->${e.message}")            }        }    }    override fun onCleared() {        Log.d("MainViewModelTAG", "onCleared: ")        super.onCleared()    }}