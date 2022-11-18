package com.lutfullayevmuhammad.mydictionary.core.di.module.room

import android.content.Context
import com.lutfullayevmuhammad.mydictionary.core.models.dictionaryUser.AppDb
import com.lutfullayevmuhammad.mydictionary.core.models.dictionaryUser.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Provides
    @Singleton
    fun getRoomDbInstance(context: Context): AppDb {
        return AppDb.getAppDbInstance(context)
    }

    @Provides
    @Singleton
    fun getItemDao(appDb: AppDb): UserDao {
        return appDb.userDao()
    }

}