package com.kewpie.dagger2demo.di

import com.kewpie.dagger2demo.module.main.Home2Fragment
import com.kewpie.dagger2demo.module.main.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Fragment注入
 * Created by kewpie
 * Date: 2018/11/24
 */
@Module
abstract class MainFragmentBindModule{
    @ContributesAndroidInjector(modules = [HomeModule::class])
    abstract fun contributeHomeFragment(): HomeFragment

    @ContributesAndroidInjector(modules = [Home2Module::class])
    abstract fun contributeHome2Fragment():Home2Fragment
}
