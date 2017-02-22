package com.zn.lichen.lcdemo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

import com.zn.lichen.framework.utils.LogUtil;

/**
 * Created by lichen on 2017/2/20.
 */

public class MyButton extends Button {
    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyButton(Context context) {
        super(context);
    }

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        LogUtil.e("MyButton------" + "dispatchTouchEvent");
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        LogUtil.e("MyButton------" + "onTouchEvent");
        return super.onTouchEvent(event);
    }
}
