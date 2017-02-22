package com.zn.lichen.lcdemo.base;

import android.os.Handler;
import android.os.Looper;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.decoder.SimpleProgressiveJpegConfig;
import com.zn.lichen.framework.base.BaseApplication;
import com.zn.lichen.framework.network.OkhttpUtil;

/**
 * Created by lichen on 2016/12/22.
 */

public class LCApplication extends BaseApplication {

    @Override
    public void onCreate() {
        OkhttpUtil.init(null);

        //初始化Fresco
        ImagePipelineConfig imagePipelineConfig = ImagePipelineConfig.newBuilder(this)
                .setProgressiveJpegConfig(new SimpleProgressiveJpegConfig())
                .build();
        Fresco.initialize(this, imagePipelineConfig);
        super.onCreate();
    }

    public static Handler getMainThread() {
        return new Handler(Looper.getMainLooper());
    }

}
