package com.zn.lichen.lcdemo.view.activity;

import android.content.Intent;
import android.os.Bundle;

import com.zn.lichen.framework.base.BaseActivity;
import com.zn.lichen.lcdemo.R;
import com.zn.lichen.lcdemo.view.fragment.TabFragment;
import com.zn.lichen.lcdemo.view.fragment.TabThirdFragment;
import com.zn.lichen.lcdemo.view.fragment.TabTwoFragment;
import com.zn.lichen.lcdemo.widget.FragmentTabHost;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.tabhost)
    FragmentTabHost mTabhost;

    private final String TAB_TAG1 = "tab_tag1";
    private final String TAB_TAG2 = "tab_tag2";
    private final String TAB_TAG3 = "tab_tag3";

    @Override
    protected String[] listReceiveActions() {
        return new String[0];
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        mTabhost.addTab(TAB_TAG1, TabFragment.class, null, R.id.tab_1);
        mTabhost.addTab(TAB_TAG2, TabTwoFragment.class, null, R.id.tab_2);
        mTabhost.addTab(TAB_TAG3, TabThirdFragment.class, null, R.id.tab_3);
        mTabhost.setUp(this, getSupportFragmentManager());
        mTabhost.setTabHostListener(new FragmentTabHost.TabHostListener() {
            @Override
            public void onTabChange(int postion, String tag) {

            }

            @Override
            public boolean onTabClick(String tag) {
                return true;
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }
}
