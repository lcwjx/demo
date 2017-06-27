package com.zn.lichen.lcdemo.view.activity


import android.os.Bundle
import com.zn.lichen.framework.base.BaseActivity
import com.zn.lichen.lcdemo.R


/**
 * Created by lichen on 2017/6/19.
 */

class PersonInfoActivity : BaseActivity() {
    override fun listReceiveActions(): Array<String> {
        return arrayOf()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_info)

    }
}
