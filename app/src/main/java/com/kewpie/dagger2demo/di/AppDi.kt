package com.kewpie.dagger2demo.di

import android.app.Application
import com.kewpie.dagger2demo.KewpieApplication
import com.kewpie.dagger2demo.di.annotation.Type
import com.kewpie.dagger2demo.model.UserBean
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Named
import javax.inject.Singleton

/**
 * App级别注入
 * Created by kewpie
 * Date: 2018/11/24
 */
@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ActivityBindModule::class
])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(kewpieApplication: KewpieApplication)
}

@Module
class AppModule {
    @Singleton
    @Provides
    fun providerXiaoMingUser(): UserBean {
        var xiaoming = UserBean()
        xiaoming.username = "小明"
        return xiaoming
    }
}