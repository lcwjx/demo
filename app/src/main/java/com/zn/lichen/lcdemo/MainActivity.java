package com.zn.lichen.lcdemo;

import android.os.Bundle;

import com.zn.lichen.framework.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected String[] listReceiveActions() {
        return new String[0];
    }
}
