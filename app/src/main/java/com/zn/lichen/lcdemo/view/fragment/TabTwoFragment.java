package com.zn.lichen.lcdemo.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zn.lichen.framework.base.BaseFragment;
import com.zn.lichen.lcdemo.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lichen on 2017/1/11.
 */

public class TabTwoFragment extends BaseFragment {

    private Unbinder mUnbinder;

    @Override
    protected String[] listReceiveActions() {
        return new String[0];
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_two_layout, null);
        mUnbinder = ButterKnife.bind(this, root);
        return root;
    }

    @Override
    public void onDestroy() {
        mUnbinder.unbind();
        super.onDestroy();
    }

}
