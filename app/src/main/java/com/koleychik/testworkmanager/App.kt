package com.koleychik.testworkmanager

import android.app.Application
import android.app.NotificationManager
import android.content.Context

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        val notificationUtils = NotificationUtils()
        val manager: NotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        val channel = notificationUtils.createChannel()

        if (channel != null) {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                manager.createNotificationChannel(channel)
            }
        }
    }
}