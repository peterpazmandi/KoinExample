package com.inspirecoding.koinexample

import android.app.Application
import com.inspirecoding.koinexample.modul.appModule
import com.inspirecoding.koinexample.modul.mainActivityViewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp: Application()
{
    override fun onCreate()
    {
        super.onCreate()

        startKoin {
            androidContext(this@MyApp)
            modules(listOf(appModule, mainActivityViewModelModule))
        }
    }
}