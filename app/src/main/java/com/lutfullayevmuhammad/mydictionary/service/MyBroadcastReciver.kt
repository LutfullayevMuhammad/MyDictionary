package com.lutfullayevmuhammad.mydictionary.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.graphics.BitmapFactory
import android.media.RingtoneManager
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.lutfullayevmuhammad.mydictionary.MainActivity
import com.lutfullayevmuhammad.mydictionary.R
import com.lutfullayevmuhammad.mydictionary.RecActivity

class MyBroadcastReciver:BroadcastReceiver() {

    private val CHANNEL_ID="channel1"
    private val notificationId=1

    override fun onReceive(p0: Context?, p1: Intent?) {
        val data = p1?.extras
        var translation = "Title"
        data?.let {
             translation = it.getString("title")!!
        }

        var icon = R.drawable.ic_baseline_translate_icon

        val alarmSong = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

        val intent = Intent(p0, RecActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(p0, 0, intent, 0)

        val builder = p0?.let {
            NotificationCompat.Builder(it, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_baseline_translate_icon)
                .setLargeIcon(BitmapFactory.decodeResource(p0.resources,icon))
                .setContentTitle("Translation")
                .setContentText(translation)
                .setContentIntent(pendingIntent)
                .setPriority(NotificationCompat.PRIORITY_MAX)
                .setSound(alarmSong)
                .addAction(0,"Open translation",pendingIntent)
                .setAutoCancel(true)
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "R.string.channel_name"
            val descriptionText = "R.string.channel_description"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }

            channel.setShowBadge(true)

            if (builder != null) {
                with(p0?.let { NotificationManagerCompat.from(it) }) {
                    // notificationId is a unique int for each notification that you must define
                    this?.notify(notificationId, builder.build())
                }
            }
            val notificationManager: NotificationManager =
                p0?.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)

        }

    }

}