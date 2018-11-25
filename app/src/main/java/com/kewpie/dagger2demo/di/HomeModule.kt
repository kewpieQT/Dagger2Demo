package com.kewpie.dagger2demo.di

import com.kewpie.dagger2demo.di.annotation.Type
import com.kewpie.dagger2demo.model.UserBean
import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * HomeFragment 注入需要的 Module
 * Created by kewpie
 * Date: 2018/11/24
 */
@Module
class HomeModule{

    @Named("fragment")
    @Provides
    fun providerXiaoHongUser() : UserBean{
        var xiaohong = UserBean()
        xiaohong.username = "小红"
        return xiaohong
    }
}