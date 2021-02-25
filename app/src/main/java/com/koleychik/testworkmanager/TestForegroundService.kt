package com.koleychik.testworkmanager

import android.app.Service
import android.content.Intent
import android.os.IBinder

class TestForegroundService : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val title = intent?.extras!!.getString(Constants.NOTIFICATION_TITLE, "")
        val text = intent.extras!!.getString(Constants.NOTIFICATION_TEXT, "")

        startForeground(
            1,
            NotificationUtils().createNotification(
                this,
                title,
                text,
                R.drawable.ic_launcher_foreground
            )
        )

        return START_STICKY
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}