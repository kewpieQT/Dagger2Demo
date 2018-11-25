package com.kewpie.dagger2demo.di

import com.kewpie.dagger2demo.di.annotation.Type
import com.kewpie.dagger2demo.model.UserBean
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * MainActivity 注入需要的 Module
 * Created by kewpie
 * Date: 2018/11/24
 */
@Module
class MainActivityModule {

    @Named("activity")
    @Provides
    fun providerXiaoGangUser() : UserBean {
        var xiaogang = UserBean()
        xiaogang.username = "小刚"
        return xiaogang
    }
}
