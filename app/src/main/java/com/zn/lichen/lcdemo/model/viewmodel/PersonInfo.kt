package com.zn.lichen.lcdemo.model.viewmodel

import android.databinding.BaseObservable

/**
 * Created by lichen on 2017/6/19.
 */
data class PersonInfo(var name: String, var age: Int, var sex: String) : BaseObservable()