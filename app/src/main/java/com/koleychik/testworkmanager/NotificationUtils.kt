package com.koleychik.testworkmanager

import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat

class NotificationUtils {

    fun createNotification(context: Context, title: String, text: String, icon : Int) : Notification{
        val intent = Intent(context, MainActivity2::class.java)
        intent.putExtra("hello", "Hello Intent")
        val pendingIntent = PendingIntent.getActivity(context, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        return NotificationCompat.Builder(context, Constants.ID_CHANNEL)
            .setContentTitle(title)
            .setContentText(text)
            .setSmallIcon(icon)
//            .setSound(alarmSound)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)
            .build()
    }

    fun createChannel() : NotificationChannel?{
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return NotificationChannel(
                Constants.ID_CHANNEL,
                Constants.NAME_CHANNEL,
                NotificationManager.IMPORTANCE_HIGH
            )
        }
        return null
    }

    fun makeNotification(context: Context, icon: Int, title: String, text: String) {
        val manager: NotificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                Constants.ID_CHANNEL,
                Constants.NAME_CHANNEL,
                NotificationManager.IMPORTANCE_HIGH
            )
            manager.createNotificationChannel(channel)
        }

        val intent = Intent(context as Activity, MainActivity2::class.java)
        intent.putExtra("hello", "Hello Intent")
        val pendingIntent = PendingIntent.getActivity(context, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        val builder = NotificationCompat.Builder(context, Constants.ID_CHANNEL)
            .setContentTitle(title)
            .setContentText(text)
            .setSmallIcon(icon)
//            .setSound(alarmSound)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)

//            .setDefaults(sound)

        manager.notify(1, builder.build())

    }

}