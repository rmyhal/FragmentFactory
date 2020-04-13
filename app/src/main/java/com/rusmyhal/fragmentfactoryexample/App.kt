package com.rusmyhal.fragmentfactoryexample

import android.app.Application
import com.rusmyhal.fragmentfactoryexample.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            fragmentFactory()
            loadKoinModules(appModules)
        }
    }
}