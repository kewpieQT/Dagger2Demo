package com.kewpie.dagger2demo.module.main

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.kewpie.dagger2demo.R
import com.kewpie.dagger2demo.di.Injectable
import com.kewpie.dagger2demo.model.UserBean
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fr_home.*
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by kewpie
 * Date: 2018/11/24
 */
class Home2Fragment : Fragment(),Injectable{

    @field:Named("fragment2")
    @Inject
    lateinit var fragmentUser : UserBean

    @field:Named("activity")
    @Inject
    lateinit var activityUser : UserBean

    @Inject
    lateinit var appUser : UserBean

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fr_home,null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragment_btn.setOnClickListener {
            Toast.makeText(context,"Fragment2 注入姓名:${fragmentUser.username}\nActivity 注入姓名：${activityUser.username}\nApplication 注入姓名：${appUser.username}", Toast.LENGTH_SHORT).show()
        }
    }


}