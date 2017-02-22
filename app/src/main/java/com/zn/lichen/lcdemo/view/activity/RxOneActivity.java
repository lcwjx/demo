package com.zn.lichen.lcdemo.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.zn.lichen.framework.base.BaseActivity;
import com.zn.lichen.lcdemo.R;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;

/**
 * Created by lichen on 2017/2/16.
 */
public class RxOneActivity extends BaseActivity {
    @BindView(R.id.getAuthCode)
    TextView mGetAuthCode;

    @Override
    protected String[] listReceiveActions() {
        return new String[0];
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_one);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        mGetAuthCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer();
            }
        });

    }

    private void startTimer() {
        Observable.interval(0, 1, TimeUnit.SECONDS)
                .take(60)
                .map(new Func1<Long, Long>() {
                    @Override
                    public Long call(Long second) {
                        return 59 - second;
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onCompleted() {
                        mGetAuthCode.setText("获取验证码");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Long aLong) {
                        mGetAuthCode.setText(aLong + "s");
                    }
                });
    }
}
