package com.zn.lichen.lcdemo.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zn.lichen.framework.base.BaseFragment;
import com.zn.lichen.framework.network.ServiceCallback;
import com.zn.lichen.framework.network.ServiceParams;
import com.zn.lichen.framework.network.ServiceTask;
import com.zn.lichen.framework.task.NetworkExcuter;
import com.zn.lichen.framework.task.NetwrokTaskError;
import com.zn.lichen.lcdemo.R;
import com.zn.lichen.lcdemo.control.service.FirstService;
import com.zn.lichen.lcdemo.model.viewmodel.TabThirdViewmodel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lichen on 2017/2/13.
 */
public class TabThirdFragment extends BaseFragment {

    @BindView(R.id.text_json)
    TextView mTextJson;
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
        View rootView = inflater.inflate(R.layout.fragment_third_layout, null);
        mUnbinder = ButterKnife.bind(this, rootView);
        initData();
        return rootView;
    }

    private void initData() {

        final TabThirdViewmodel viewmodel = new TabThirdViewmodel();
        ServiceParams serviceParams = FirstService.getJson(viewmodel);
        ServiceTask serviceTask = new ServiceTask(serviceParams);
        serviceTask.setShowProcess(true).setCancelable(true);
        serviceTask.setCallback(new ServiceCallback() {
            @Override
            public void onTaskStart(String serverTag) {

            }

            @Override
            public void onTaskSuccess(String serverTag) {
                mTextJson.setText(viewmodel.json);

            }

            @Override
            public void onTaskFail(NetwrokTaskError error, String serverTag) {

            }
        });
        NetworkExcuter.getInstance().excute(serviceTask, TabThirdFragment.this);

    }

    @Override
    public void onDestroy() {
        mUnbinder.unbind();
        super.onDestroy();
    }
}
