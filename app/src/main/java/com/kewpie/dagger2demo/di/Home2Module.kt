package com.kewpie.dagger2demo.di

import com.kewpie.dagger2demo.model.UserBean
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * Home2Fragment 注入需要的 Module
 * Created by kewpie
 * Date: 2018/11/25
 */

@Module
class Home2Module{

    @Named("fragment2")
    @Provides
    fun providerXiaoHuaUser() : UserBean {
        var xiaohua = UserBean()
        xiaohua.username = "小花"
        return xiaohua
    }
}