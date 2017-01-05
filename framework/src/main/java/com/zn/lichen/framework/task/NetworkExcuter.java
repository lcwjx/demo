package com.zn.lichen.framework.task;

import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.zn.lichen.framework.interfaces.MarkAble;
import com.zn.lichen.framework.network.OkhttpUtil;
import com.zn.lichen.framework.network.ServiceCallback;
import com.zn.lichen.framework.network.ServiceParams;
import com.zn.lichen.framework.network.ServiceTask;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by lichen on 2017/1/3.
 */

public class NetworkExcuter {

    private static NetworkExcuter sExcuter = new NetworkExcuter();
    private final Handler mHandler;
    private final OkHttpClient mOkHttpClient;
    private HashMap<String, ServiceTask> taskModelHashMap = new HashMap<>();

    public static NetworkExcuter getInstance() {
        return sExcuter;
    }

    private NetworkExcuter() {
        mHandler = new Handler(Looper.getMainLooper());
        mOkHttpClient = OkhttpUtil.getOkHttpClient();
    }

    /**
     * 执行网络请求
     *
     * @param taskModel
     * @param markAble
     */
    public void excute(ServiceTask taskModel, MarkAble markAble) {
        taskModel.getTagConfig().contextTag = markAble.getInstanceTag();
        taskModelHashMap.put(taskModel.getTagConfig().getTag(), taskModel);
        if (markAble instanceof FragmentActivity) {
            getDataWithLoading(((FragmentActivity) markAble).getSupportFragmentManager(), taskModel);
        } else if (markAble instanceof Fragment) {
            getDataWithLoading(((Fragment) markAble).getFragmentManager(), taskModel);
        } else {
            getDataWithLoading(null, taskModel);
        }
    }

    private void getDataWithLoading(FragmentManager fragmentManager, ServiceTask taskModel) {
        ServiceCallback callback = taskModel.getCallback();
        ServiceParams serviceParams = taskModel.getServiceParams();
        final String tag = taskModel.getTag();
        Request okRequest = makeOkRequest(taskModel);

        Callback networkcallback = new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //网路异常会走到这
                e.printStackTrace();
                handleNetworkError(tag);

                releaseTask(tag);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //只要服务器端有数据返回，就会走到这
                if (response.code() == 200) {
                    //处理正常数据
                    handleResponse(response, tag);
                } else {
                    //处理异常数据
                    handleServerError(response, tag);

                }


                releaseTask(tag);
            }
        };

        if (okRequest != null) {
            if (serviceParams.isNeedCacheData()) {
                //缓存数据
                handleCacheData(tag);
            }
            if (callback != null) {
                callback.onTaskStart(serviceParams.getServiceTag());
            }
            if (taskModel.dataConfig.useVirtualData) {
                //使用模拟数据
                useVirtualData(tag);
            } else {
                serviceParams.modifyNetworkExecutor(mOkHttpClient).newCall(okRequest).enqueue(networkcallback);
            }
        }

    }


    /**
     * 处理正常返回的数据
     *
     * @param response
     * @param tag
     */
    private void handleResponse(Response response, String tag) {


    }

    /**
     * 网路正常，但是接口返回异常状态码处理
     *
     * @param response
     * @param tag
     */
    private void handleServerError(Response response, String tag) {

    }

    /**
     * 网路异常处理，如超时，无网路连接，请求取消
     *
     * @param tag
     */
    private void handleNetworkError(String tag) {

    }

    /**
     * 使用模拟数据
     *
     * @param tag
     */
    private void useVirtualData(String tag) {

    }

    /**
     * 缓存数据
     *
     * @param tag
     */
    private void handleCacheData(String tag) {

    }

    /**
     * 构建okhttp的requset
     *
     * @param taskModel
     * @return
     */
    private Request makeOkRequest(ServiceTask taskModel) {
        Request request = taskModel.serviceParams.getRequest(taskModel.getTagConfig().getTag());
        return request;
    }

    /**
     * 从map中释放
     *
     * @param tag
     */
    private void releaseTask(String tag) {
        taskModelHashMap.remove(tag);
    }

    public void cancelRequest(String tag) {

    }
}
