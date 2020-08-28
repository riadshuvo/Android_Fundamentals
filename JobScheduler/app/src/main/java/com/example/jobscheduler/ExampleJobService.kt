package com.example.jobscheduler

import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log

class ExampleJobService: JobService() {
    val TAG : String = "ExampleJobService"
    var jobCancelled : Boolean = false

    override fun onStopJob(params: JobParameters?): Boolean {

        Log.d(TAG, "Job cancelled before completion");
        jobCancelled = true;
        return true;

    }

    private fun doBackgroundWork(params: JobParameters?) {
        Thread(Runnable {
            for (i in 0..9) {
                Log.d(TAG, "run: $i")

                if (jobCancelled) {
                    return@Runnable;
                }

                try {
                    Thread.sleep(1000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
            Log.d(TAG, "Job finished")
            jobFinished(params, false)
        }).start()
    }

    override fun onStartJob(params: JobParameters?): Boolean {
        Log.d(TAG,"Job Started")
        doBackgroundWork(params)
        return true
    }
}