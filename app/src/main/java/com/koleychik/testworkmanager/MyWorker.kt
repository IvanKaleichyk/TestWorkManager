package com.koleychik.testworkmanager

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(context: Context, parameters: WorkerParameters) : Worker(context, parameters) {
    override fun doWork(): Result {
        val intentService = Intent(applicationContext, TestForegroundService::class.java)
        intentService.putExtra(Constants.NOTIFICATION_TITLE, "TITLE")
        intentService.putExtra(Constants.NOTIFICATION_TEXT, "Hello")
        applicationContext.startService(intentService)

        inputData.keyValueMap

        Log.d(Constants.TAG, "StartWork")
//        val notificationUtils = NotificationUtils()
//        notificationUtils.makeNotification(applicationContext, R.mipmap.ic_launcher_round, "title", "startMainActivity")

//        val notificationUtils = NotificationUtils()
//        notificationUtils.makeNotification(
//            applicationContext,
//            R.mipmap.ic_launcher,
//            "hello",
//            "now message"
//        )
        return Result.success()
    }
}