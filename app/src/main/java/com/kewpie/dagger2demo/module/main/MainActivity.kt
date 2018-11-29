package com.kewpie.dagger2demo.module.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentPagerAdapter
import android.widget.Toast
import com.kewpie.dagger2demo.R
import com.kewpie.dagger2demo.model.UserBean
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import javax.inject.Named

class MainActivity : AppCompatActivity() ,HasSupportFragmentInjector{
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = dispatchingAndroidInjector

    @field:Named("activity")
    @Inject
    lateinit var activityUser : UserBean

    @Inject
    lateinit var appUser : UserBean

    var titles  = arrayOf("fragment1","fragment2")
    var fragmentList = mutableListOf<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
            Toast.makeText(applicationContext,"Activity 注入姓名:${activityUser.username}\nApplication 注入姓名：${appUser.username}",Toast.LENGTH_SHORT).show()
        }

        for (i in titles.indices){
            if (i==1){
                fragmentList.add(Home2Fragment())
            }else{
                fragmentList.add(HomeFragment())
            }
        }

        view_pager.adapter = object : FragmentPagerAdapter(supportFragmentManager){
            override fun getItem(position: Int): Fragment {
              return  fragmentList[position]
            }

            override fun getCount(): Int {
                return fragmentList.size
            }

            override fun getPageTitle(position: Int): CharSequence? {
                return titles[position]
            }
        }

        tab_layout.setupWithViewPager(view_pager)
    }
}
