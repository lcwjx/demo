package com.zn.lichen.lcdemo.view.activity

import android.content.Intent
import android.os.Bundle
import com.zn.lichen.framework.base.BaseActivity
import com.zn.lichen.lcdemo.R
import com.zn.lichen.lcdemo.model.entity.Person
import kotlinx.android.synthetic.main.activity_kotlin.*

/**
 * Created by lichen on 2017/5/31.
 */

class KotlinActivity : BaseActivity() {
    override fun listReceiveActions(): Array<String> {
//        xTODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return arrayOf()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
        text_kotlin.text = "kotlin"
        val person = Person()
        person.age = 23.toString()
        person.name = "张三"
        initView()
    }

    private fun initView() {
        text_kotlin.setOnClickListener {
//            ActivityExchangeManager.goActivity(applicationContext, RxOneActivity::class.java)
            startActivity(Intent(this@KotlinActivity,RxOneActivity::class.java))
            finish()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
