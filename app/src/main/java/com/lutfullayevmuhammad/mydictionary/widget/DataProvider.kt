package com.lutfullayevmuhammad.mydictionary.widget

import android.R.id.text1
import android.R.layout.*
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import android.widget.RemoteViewsService.RemoteViewsFactory
import com.lutfullayevmuhammad.mydictionary.core.models.dictionaryRec.RecData

class DataProvider(context: Context?, intent: Intent?) : RemoteViewsFactory {

    var myListView: MutableList<String> = ArrayList()
    var mContext: Context? = null

    init {
        mContext = context
    }

    override fun onCreate() {
        initData()
    }

    override fun onDataSetChanged() {
        initData()
    }

    override fun onDestroy() {}
    override fun getCount(): Int {
        return myListView.size
    }

    override fun getViewAt(position: Int): RemoteViews {
        val view = RemoteViews(
            mContext!!.packageName,
            simple_list_item_1
        )
        view.setTextViewText(text1, myListView[position])
        return view
    }

    override fun getLoadingView(): RemoteViews? {
        return null
    }

    override fun getViewTypeCount(): Int {
        return 1
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    private fun initData() {
        myListView.clear()
        for (i in 1..20) {
            myListView.add(recData().random().dictionary)
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