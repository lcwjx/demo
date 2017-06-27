package com.zn.lichen.lcdemo.view.activity;

import android.os.Bundle;

import com.zn.lichen.framework.base.BaseActivity;

/**
 * Created by lichen on 2017/3/15.
 */

public class DownloadActivity extends BaseActivity {
    @Override
    protected String[] listReceiveActions() {
        return new String[0];
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_download_layout);

//         DataBindingUtil.setContentView(this, R.layout.activity_download_layout);
        initData();
    }

    private void initData() {


    }
}
