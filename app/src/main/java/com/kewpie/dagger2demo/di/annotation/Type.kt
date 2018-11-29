package com.kewpie.dagger2demo.di.annotation

import javax.inject.Qualifier

/**
 * Created by kewpie
 * Date: 2018/11/25
 */
@Qualifier
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class Type (val value: String = "")