package id.taufiq.myapplication

import android.app.Application

/**
 * Created By Taufiq on 1/31/2021.
 *
 */

class CustomApplication : Application() {
    companion object {
        lateinit var application: Application
    }

    override fun onCreate() {
        super.onCreate()

        application = this
    }
}