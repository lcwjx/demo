package com.zn.lichen.lcdemo.control.service;

import com.zn.lichen.framework.network.BusinessParser;
import com.zn.lichen.framework.network.BusinessResult;
import com.zn.lichen.framework.network.GetServiceParams;
import com.zn.lichen.framework.network.ServiceParams;
import com.zn.lichen.lcdemo.model.viewmodel.TabThirdViewmodel;

/**
 * Created by lichen on 2017/2/13.
 */

public class FirstService {
    public static ServiceParams getJson(final TabThirdViewmodel viewmodel) {
        GetServiceParams serviceParams = new GetServiceParams<>("https://test-mhis-siapp.pingan.com.cn:57443/siapp-sms/cms/open/picturesAndIndexConfig?version=2.8.0", String.class);
        serviceParams.addHeader("zoneCode", "0086");
        serviceParams.setBusinessParser(new BusinessParser<String>() {

            @Override
            public BusinessResult parseData(String s) {
//                BusinessResult result = new BusinessResult(true);
//                viewmodel.json = s;
                BusinessResult result = new BusinessResult(s);
                if (result.isSuccess) {
                    viewmodel.json = s;
                } else {
                    result.isSuccess = false;
                }
                return result;
            }
        });
        return serviceParams;
    }
}
