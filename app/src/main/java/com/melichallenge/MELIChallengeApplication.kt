package com.melichallenge

import android.app.Activity
import android.content.pm.ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR
import android.os.Bundle
import androidx.multidex.MultiDexApplication
import com.jakewharton.threetenabp.AndroidThreeTen
import com.melichallenge.di.applicationModule
import com.melichallenge.di.dataModule
import com.melichallenge.di.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MELIChallengeApplication : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityPaused(activity: Activity) {}
            override fun onActivityStarted(activity: Activity) {}
            override fun onActivityDestroyed(activity: Activity) {}
            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
            override fun onActivityStopped(activity: Activity) {}
            override fun onActivityResumed(activity: Activity) {}
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                activity.requestedOrientation = SCREEN_ORIENTATION_FULL_SENSOR
            }
        })

        AndroidThreeTen.init(this)

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MELIChallengeApplication)
            modules(applicationModule, domainModule, dataModule)
        }
    }
}
