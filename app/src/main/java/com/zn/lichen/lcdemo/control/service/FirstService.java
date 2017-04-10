package com.zn.lichen.lcdemo.control.service;

import com.zn.lichen.framework.network.BusinessParser;
import com.zn.lichen.framework.network.BusinessResult;
import com.zn.lichen.framework.network.GetServiceParams;
import com.zn.lichen.framework.network.ServiceParams;
import com.zn.lichen.lcdemo.model.entity.HomepageCircleImageEntity;
import com.zn.lichen.lcdemo.model.response.ConfigResponse;
import com.zn.lichen.lcdemo.model.viewmodel.TabThirdViewmodel;

/**
 * Created by lichen on 2017/2/13.
 */

public class FirstService {
    public static ServiceParams getJson(final TabThirdViewmodel viewModel) {
        GetServiceParams serviceParams = new GetServiceParams<>("https://test-mhis-siapp.pingan.com.cn:57443/siapp-sms/cms/open/picturesAndIndexConfig?version=2.8.0", ConfigResponse.class);
        serviceParams.addHeader("zoneCode", "0086");
        serviceParams.setServiceTag("getConfig").setBusinessParser(new BusinessParser<ConfigResponse>() {

            @Override
            public BusinessResult parseData(ConfigResponse configResponse) {
                BusinessResult result = new BusinessResult(configResponse);
                if (result.isSuccess) {
                    result.isSuccess = parseConfigData(viewModel, configResponse);
                } else {
                    result.isSuccess = false;
                }
                return result;
            }

        });
        return serviceParams;
    }

    private static boolean parseConfigData(TabThirdViewmodel viewModel, ConfigResponse configResponse) {
        ConfigResponse.BodyBean body = configResponse.body;
        viewModel.circleImageEntities.clear();
        if (body.pictures != null) {
            for (ConfigResponse.BodyBean.PicturesBean picturesEntity : body.pictures) {
                HomepageCircleImageEntity imageEntity = new HomepageCircleImageEntity();
                imageEntity.imageClickURL = picturesEntity.imageClickURL;
                imageEntity.imageUrl = picturesEntity.imageUrl;
//                imageEntity.imageUpName = picturesEntity.imageUpName;
//                imageEntity.activityType = picturesEntity.activityType;
//                imageEntity.moduleURL = picturesEntity.moduleURL;
                viewModel.circleImageEntities.add(imageEntity);
            }
        }
//        viewModel.serviceEntities.clear();
//        if (body.indexConfig != null) {
//            for (HomepageConfigResponse.BodyEntity.IndexConfigEntity indexConfigEntity : body.indexConfig) {
//                HomepageServiceEntity serviceEntity = new HomepageServiceEntity();
//                serviceEntity.title = indexConfigEntity.title;
//                serviceEntity.subTitle = indexConfigEntity.subTitle;
//                if (TextUtils.isEmpty(indexConfigEntity.titleColor)) {
//                    serviceEntity.color = R.color.color_text_black;
//                } else {
//                    serviceEntity.color = Color.parseColor(indexConfigEntity.titleColor);
//                }
//                if (TextUtils.isEmpty(indexConfigEntity.subTitleColor)) {
//                    serviceEntity.subTitlecolor = R.color.color_text_black;
//                } else {
//                    serviceEntity.subTitlecolor = Color.parseColor(indexConfigEntity.subTitleColor);
//                }
//                serviceEntity.directory = indexConfigEntity.directory;
//                serviceEntity.group = indexConfigEntity.group;
//                serviceEntity.imageURL = indexConfigEntity.imageUrl;
//                //commit by ken on 20160529 start 赋值模块名为CMS配置环境中查看的名字.
//                //serviceEntity.title = indexConfigEntity.moduleName;
//                //commit by ken on 20160529 end
//                serviceEntity.modelId = indexConfigEntity.modelId;
//                viewModel.serviceEntities.add(serviceEntity);
//            }
//        }
//        viewModel.bottomPictures.clear();
//        if (body.bottomPictures != null) {
//            for (HomepageConfigResponse.BodyEntity.PicturesEntity picturesEntity : body.bottomPictures) {
//                HomepageBottomPocturesEntity bottomPocturesEntity = new HomepageBottomPocturesEntity();
//
//                bottomPocturesEntity.appType = picturesEntity.appType;
//                bottomPocturesEntity.imageClickURL = picturesEntity.imageClickURL;
//                bottomPocturesEntity.opener = picturesEntity.opener;
//                bottomPocturesEntity.version = picturesEntity.version;
//                bottomPocturesEntity.imageID = picturesEntity.imageID;
//                bottomPocturesEntity.imageUrl = picturesEntity.imageUrl;
//                bottomPocturesEntity.zoneCode = picturesEntity.zoneCode;
//                bottomPocturesEntity.imageName = picturesEntity.imageName;
//                bottomPocturesEntity.imageClickType = picturesEntity.imageClickType;
//
//                viewModel.bottomPictures.add(bottomPocturesEntity);
//            }
//        }
        return true;
    }
}
