package com.zn.lichen.framework.task;

import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.google.gson.Gson;
import com.zn.lichen.framework.constants.DialogType;
import com.zn.lichen.framework.interfaces.MarkAble;
import com.zn.lichen.framework.manager.DialogManager;
import com.zn.lichen.framework.model.entity.DialogExchangeModel;
import com.zn.lichen.framework.network.BusinessResult;
import com.zn.lichen.framework.network.OkhttpUtil;
import com.zn.lichen.framework.network.ServiceCallback;
import com.zn.lichen.framework.network.ServiceParams;
import com.zn.lichen.framework.network.ServiceTask;
import com.zn.lichen.framework.utils.LogUtil;
import com.zn.lichen.framework.widget.ProcessDialogFragment;

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
        final ProcessDialogFragment processDialog = fragmentManager == null ? null : makeProcessDialog(taskModel, fragmentManager, tag);
        Request okRequest = makeOkRequest(taskModel);
        Callback networkcallback = new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //网路异常会走到这
                e.printStackTrace();
                handleNetworkError(tag);
                if (processDialog != null) {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            processDialog.dismiss();
                        }
                    });
                }
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

                if (processDialog != null) {
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            processDialog.dismiss();
                        }
                    });
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
     * 使用缓存数据
     *
     * @param tag
     */
    private void handleCacheData(String tag) {

    }


    /**
     * 处理正常返回的数据
     *
     * @param response
     * @param tag
     */
    private <T> void handleResponse(Response response, String tag) {
        ServiceTask taskModel = taskModelHashMap.get(tag);
        final ServiceParams serviceParams = taskModel.getServiceParams();
        final ServiceCallback callback = taskModel.getCallback();
        final T t;
        try {
            String string = response.body().string();
            LogUtil.d(string);
            if (serviceParams.getResponseType() == String.class) {
                t = (T) string;
            } else {
                t = (T) new Gson().fromJson(string, serviceParams.getResponseType());
            }

        } catch (IOException e) {
            e.printStackTrace();
            NetwrokTaskError error = new NetwrokTaskError(NetwrokTaskError.TaskCodeList.ServerError, "接口异常");
            dispatchErrorResponse(callback, error, serviceParams.getServiceTag());
            return;
        }

        mHandler.post(new Runnable() {
            @Override
            public void run() {
                if (serviceParams.getBusinessParser() != null) {
                    if (t == null) {
                        NetwrokTaskError error = new NetwrokTaskError(NetwrokTaskError.TaskCodeList.ServerError, "数据异常");
                        dispatchErrorResponse(callback, error, serviceParams.getServiceTag());
                        return;
                    }
                    BusinessResult result = serviceParams.getBusinessParser().parseData(t);
                    if (result.isSuccess) {
                        cacheResponse(serviceParams, t);
                        dispatchResponse(serviceParams.getServiceTag(), callback);
                    } else {
                        NetwrokTaskError error = new NetwrokTaskError(result);
                        dispatchErrorResponse(callback, error, serviceParams.getServiceTag());
                    }
                } else {
                    dispatchResponse(serviceParams.getServiceTag(), callback);
                }
            }
        });
    }

    /**
     * 对response进行分发
     *
     * @param serviceTag
     * @param callback
     */
    private void dispatchResponse(String serviceTag, ServiceCallback callback) {
        if (callback != null) {
            callback.onTaskSuccess(serviceTag);
        }
    }

    /**
     * 分发异常，回传给callback
     *
     * @param callback
     * @param error
     * @param serviceTag
     */
    private void dispatchErrorResponse(ServiceCallback callback, NetwrokTaskError error, String serviceTag) {
        if (callback != null) {
            callback.onTaskFail(error, serviceTag);
        }
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
     * 取消请求
     *
     * @param tag
     */
    public void cancelRequest(String tag) {

    }

    /**
     * 缓存数据
     *
     * @param serviceParams
     * @param t
     * @param <T>
     */
    private <T> void cacheResponse(ServiceParams serviceParams, T t) {

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

    /**
     * 根据task配置进行process loading处理
     *
     * @param taskModel
     * @param fragmentManager
     * @param tag
     * @return
     */
    private ProcessDialogFragment makeProcessDialog(ServiceTask taskModel, FragmentManager fragmentManager, String tag) {
        UIConfig uiConfig = taskModel.getUiConfig();
        if (uiConfig.isShowProcess) {
            DialogExchangeModel.DialogExchangeModelBuilder builder = new DialogExchangeModel.DialogExchangeModelBuilder(DialogType.PROGRESS, tag);
            builder.setBackable(uiConfig.isCancelable).setDialogContext(uiConfig.progressContent);
            return (ProcessDialogFragment) DialogManager.showDialogFragment(fragmentManager, builder.creat());
        } else {
            return null;
        }
    }
}
