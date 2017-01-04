package com.zn.lichen.lcdemo.base;

import android.os.Handler;
import android.os.Looper;

import com.zn.lichen.framework.base.BaseApplication;

/**
 * Created by lichen on 2016/12/22.
 */

public class LCApplication extends BaseApplication {

    public static Handler getMainThread() {
        return new Handler(Looper.getMainLooper());
    }

}
