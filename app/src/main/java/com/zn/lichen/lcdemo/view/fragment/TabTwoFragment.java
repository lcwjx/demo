package com.zn.lichen.lcdemo.view.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zn.lichen.framework.base.BaseFragment;
import com.zn.lichen.lcdemo.R;
import com.zn.lichen.lcdemo.widget.LineChartView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lichen on 2017/1/11.
 */

public class TabTwoFragment extends BaseFragment {

    @BindView(R.id.lcv)
    LineChartView mLcv;
    private Unbinder mUnbinder;

    private List<LineChartView.ItemBean> mItems;
    private int[] shadeColors;

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
        initData();
        return root;
    }

    @Override
    public void onDestroy() {
        mUnbinder.unbind();
        super.onDestroy();
    }

    private void initData() {
        //  初始化折线数据
        mItems = new ArrayList<>();
        mItems.add(new LineChartView.ItemBean(1489507200, 23));
        mItems.add(new LineChartView.ItemBean(1489593600, 88));
        mItems.add(new LineChartView.ItemBean(1489680000, 60));
        mItems.add(new LineChartView.ItemBean(1489766400, 50));
        mItems.add(new LineChartView.ItemBean(1489852800, 70));
        mItems.add(new LineChartView.ItemBean(1489939200, 10));
        mItems.add(new LineChartView.ItemBean(1490025600, 33));
        mItems.add(new LineChartView.ItemBean(1490112000, 44));
        mItems.add(new LineChartView.ItemBean(1490198400, 99));
        mItems.add(new LineChartView.ItemBean(1490284800, 17));

        shadeColors = new int[]{
                Color.argb(100, 255, 86, 86), Color.argb(15, 255, 86, 86),
                Color.argb(0, 255, 86, 86)};

        //  设置折线数据
        mLcv.setItems(mItems);
        //  设置渐变颜色
        mLcv.setShadeColors(shadeColors);
        //  开启动画
        mLcv.startAnim(mLcv, 2000);
    }


}
