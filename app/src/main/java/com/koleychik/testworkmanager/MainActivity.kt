package com.koleychik.testworkmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
            WorkManager.getInstance(this).enqueue(makePeriodicWork())
//            WorkManager.getInstance(this).enqueueUniquePeriodicWork(
//                "TAG_WORKER",
//                ExistingPeriodicWorkPolicy.KEEP,
//                makePeriodicWork()
//            )

        }

//        val constants = makeConstraints()

//        makePeriodicWork()
//
//        val notificationUtils = NotificationUtils()
//        notificationUtils.makeNotification(this, R.mipmap.ic_launcher_round, "title", "startMainActivity")

    }

    private fun makeOnTimeRequests() = OneTimeWorkRequest.Builder(MyWorker::class.java).build()

    private fun makeConstraints() = Constraints.Builder()
        .setRequiredNetworkType(NetworkType.CONNECTED)
        .setRequiresBatteryNotLow(true)
        .build()

    private fun makePeriodicWork() =
        PeriodicWorkRequest.Builder(MyWorker::class.java, 1, TimeUnit.MINUTES)
            .setConstraints(makeConstraints())
            .addTag("TAG_WORKER")
            .build()
}