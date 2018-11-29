package com.kewpie.dagger2demo

import android.app.Activity
import android.app.Application
import com.kewpie.dagger2demo.di.AppInjector
import com.kewpie.dagger2demo.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject
import kotlin.properties.Delegates

/**
 * Created by kewpie
 * Date: 2018/11/24
 */

class KewpieApplication : Application(), HasActivityInjector {
    /**
     * 分发Activity的注入
     */
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>
    override fun activityInjector() = dispatchingAndroidInjector

    companion object {
        var instance : KewpieApplication by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        //Application级别注入
        AppInjector.init(this)

    }
}