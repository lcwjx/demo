package com.zn.lichen.lcdemo.model.viewmodel;

import com.zn.lichen.framework.model.viewmodel.BaseViewModel;
import com.zn.lichen.lcdemo.model.entity.HomepageBottomPocturesEntity;
import com.zn.lichen.lcdemo.model.entity.HomepageCircleImageEntity;
import com.zn.lichen.lcdemo.model.entity.HomepageServiceEntity;

import java.util.ArrayList;

/**
 * Created by lichen on 2017/2/13.
 */

public class TabThirdViewmodel extends BaseViewModel{
    public ArrayList<HomepageCircleImageEntity> circleImageEntities = new ArrayList<>();
    public ArrayList<HomepageServiceEntity> serviceEntities = new ArrayList<>();

    public ArrayList<HomepageBottomPocturesEntity> bottomPictures = new ArrayList<>();
}
