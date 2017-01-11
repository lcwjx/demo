package com.zn.lichen.lcdemo.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zn.lichen.framework.base.BaseFragment;
import com.zn.lichen.lcdemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lichen on 2017/1/11.
 */

public class TabTwoFragment extends BaseFragment {
    @BindView(R.id.content_text)
    TextView mContentText;

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
        View root = inflater.inflate(R.layout.fragment_layout, null);
        mUnbinder = ButterKnife.bind(this, root);
        mContentText.setText("TabTwoFragment");
        return root;
    }

    @Override
    public void onDestroy() {
        mUnbinder.unbind();
        super.onDestroy();
    }
}
