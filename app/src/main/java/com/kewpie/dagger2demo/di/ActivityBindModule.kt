package com.kewpie.dagger2demo.di

import com.kewpie.dagger2demo.module.main.MainActivity
import com.kewpie.dagger2demo.di.annotation.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Activity 注入，并且提供Fragment注入绑定
 * Created by kewpie
 * Date: 2018/11/24
 */
@Module
abstract class ActivityBindModule{
    @ActivityScope
    @ContributesAndroidInjector(modules = [
        MainActivityModule::class,
        MainFragmentBindModule::class
    ])
    abstract fun MainActivityInjector() : MainActivity
}