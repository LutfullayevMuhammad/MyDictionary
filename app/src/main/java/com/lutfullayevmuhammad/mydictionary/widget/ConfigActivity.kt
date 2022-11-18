package com.lutfullayevmuhammad.mydictionary.widget

import android.app.Activity
import android.appwidget.AppWidgetManager
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.lutfullayevmuhammad.mydictionary.R
import com.lutfullayevmuhammad.mydictionary.databinding.ConfigActivityBinding

class ConfigActivity : Activity() {

    private val binding: ConfigActivityBinding by lazy {
        ConfigActivityBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setResult(RESULT_CANCELED)

        binding.setupWidget.setOnClickListener {
            handleSetupWidget()
        }

    }

    private fun handleSetupWidget() {
        showAppWidget()
    }

    var appWidgetId = 0
    private fun showAppWidget() {
        appWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID
        val intent = intent
        val extras = intent.extras
        if (extras != null) {
            appWidgetId = extras.getInt(
                AppWidgetManager.EXTRA_APPWIDGET_ID,
                AppWidgetManager.INVALID_APPWIDGET_ID
            )
            if (appWidgetId == AppWidgetManager.INVALID_APPWIDGET_ID) {
                finish()
            }

            val resultValue = Intent()
            resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
            setResult(RESULT_OK, resultValue)
            finish()
        }
    }
}