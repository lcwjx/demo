package com.zn.lichen.lcdemo.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zn.lichen.framework.base.BaseFragment;
import com.zn.lichen.framework.utils.LogUtil;
import com.zn.lichen.lcdemo.R;
import com.zn.lichen.lcdemo.view.activity.RxOneActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lichen on 2017/1/11.
 */

public class TabFragment extends BaseFragment {
    @BindView(R.id.content_text)
    TextView mContentText;
//    @BindView(R.id.main_sdv)
//    SimpleDraweeView mMainSdv;

    private Unbinder mUnbinder;
    private int mDownX;
    private int mDownY;

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
        View root = inflater.inflate(R.layout.fragment_layout, container, false);
        mUnbinder = ButterKnife.bind(this, root);
        mContentText.setText("TabFragment");

        initView();
        return root;
    }

    private void initView() {
        mContentText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), RxOneActivity.class);
                startActivity(intent);
            }
        });
        mContentText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mDownX = (int) event.getX();
                        mDownY = (int) event.getY();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        int moveX = (int) event.getX();
                        int moveY = (int) event.getY();
                        int tempX = moveX - mDownX;
                        int tempY = moveY - mDownY;
                        LogUtil.e("mContentText----onTouch----tempX" + tempX);
                        LogUtil.e("mContentText----onTouch----tempY" + tempY);
                        break;
                    case MotionEvent.ACTION_UP:
                        LogUtil.e("mContentText----onTouch----actionUp");
                        break;
                }
                return false;
            }
        });
//        mMainSdv.setImageURI(Uri.parse("http://my.csdn.net/uploads/avatar_ylscp.jpg"));
    }

    @Override
    public void onDestroy() {
        mUnbinder.unbind();
        super.onDestroy();
    }
}
