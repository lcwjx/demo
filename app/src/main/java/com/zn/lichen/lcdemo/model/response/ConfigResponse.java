package com.zn.lichen.lcdemo.model.response;

import com.zn.lichen.framework.model.response.BaseResponse;

import java.util.List;

/**
 * Created by lichen on 2017/3/21.
 */

public class ConfigResponse extends BaseResponse {

    /**
     * page : null
     * body : {"pictures":[{"version":"2.8.0","imageClickType":"client","opener":"app","appType":"2","imageID":"9","imageName":"上线了(新农合)","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/FuzT4cYLL9-3xMmefYuTPTk0cjRN","zoneCode":"0086"},{"imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/FmiPlUmpatp_O4IHsf8Dckhk9Avo","opener":"app","imageID":"1","zoneCode":"0086","imageClickType":"client","appType":"1","version":"2.8.0","imageName":"上线了"},{"imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/FiUqC1Da908Xn0WFO984d1DoSKhr","imageID":"3","imageName":"医保帐户","opener":"app","imageClickType":"client","version":"2.8.0","appType":"2","zoneCode":"0086","imageClickURL":"25"},{"appType":"1","opener":"app","imageID":"2","imageClickType":"client","imageClickURL":"17","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/FuzU-sII1ntcrWi0Rr598fu66m22","imageName":"健康档案","version":"2.8.0","zoneCode":"0086"},{"imageClickType":"client","zoneCode":"0086","imageUrl":"http://7xrraa.com1.z0.glb.clouddn.com/leping03.png","imageID":"6","imageClickURL":"23","version":"2.8.0","imageName":"慢病随访","appType":"2","opener":"app"},{"opener":"app","imageID":"3","version":"2.8.0","zoneCode":"0086","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/FofJxg4NTQx23QFCC6ECBUlw15gs","imageClickType":"client","appType":"1","imageName":"医保帐户","imageClickURL":"1"},{"imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/Flt9E-VCcaIdY1ma68-m4VLzo_iD","imageClickURL":"40","opener":"app","version":"2.8.0","imageID":"15","imageName":"签到有礼","zoneCode":"0086","imageClickType":"client","appType":"1"}],"indexConfig":[{"titleColor":"#333333","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/Fj0P74cR-gW-l-HlUMBU7r71w1Oo","group":"公共服务","directory":"app.drugExpense","subTitleColor":"#666666","appType":"2","moduleName":"报销目录","modelId":"19","version":"2.8.0","zoneCode":"0086","title":"报销目录","subTitle":"看看你的药品能否报销","moduleNum":"2"},{"subTitle":"医疗健康  资讯信息","titleColor":"#333333","modelId":"40","appType":"2","version":"2.8.0","title":"资讯中心","group":"公共服务","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/FoULQGOL2FNbgNDMVnttmnT4UJ-D","zoneCode":"0086","moduleNum":"2","directory":"app.inqueryCenter","moduleName":"资讯中心(新农合)","subTitleColor":"#666666"},{"subTitleColor":"#666666","subTitle":"政策动态 权威解读","titleColor":"#333333","directory":"app.newsletterPage","modelId":"39","moduleNum":"2","title":"政策解读","group":"公共服务","moduleName":"政策解读（新农合）","zoneCode":"0086","appType":"2","version":"2.8.0","param":"1","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/Fj_sc0Te8LnZwj74PHl_R-r5gTa1"},{"moduleNum":"2","directory":"app.treatQuery","moduleName":"待遇查询（新农合）","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/Fsp5FNUfwgnBSFh3IYNz40cY4DZx","modelId":"37","param":"","subTitle":"报销待遇 便捷速查","group":"公共服务","subTitleColor":"#666666","title":"待遇查询","appType":"2","version":"2.8.0","titleColor":"#333333","zoneCode":"0086"},{"subTitleColor":"#666666","moduleNum":"2","appType":"2","version":"2.8.0","titleColor":"#333333","modelId":"38","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/FlfziBN8pzdTLmCbb3_iUoXf-fHj","directory":"app.notices","moduleName":"消息公告（新农合）","zoneCode":"0086","group":"公共服务","subTitle":"最新资讯 即刻送达","title":"消息公告"},{"appType":"2","subTitleColor":"#666666","subTitle":"比例确定 报销明晰","moduleName":"报销比例（新农合）","zoneCode":"0086","version":"2.8.0","modelId":"35","group":"公共服务","moduleNum":"2","titleColor":"#333333","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/Fv1OPRNrbia7kD8KxBitbIUKJCHn","directory":"app.reimbursePercent","title":"报销比例"},{"modelId":"33","version":"2.8.0","moduleNum":"","group":"公共服务","appType":"1","zoneCode":"0086","directory":"","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/Fl846eNfHBJ_V3YCS3FdisHJRUaa","subTitle":"便捷生活小助手","titleColor":"#a4c65f","subTitleColor":"#999999","moduleName":"生活服务","title":"生活服务"},{"group":"公共服务","directory":"app.accountSearch","version":"2.8.0","title":"医保账户","subTitleColor":"#999999","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/FosqaSlscvns7ELXGKcaDE_z5SQ7","zoneCode":"0086","subTitle":"看看医保卡上还有多少钱","moduleName":"医保账户","titleColor":"#36b293","appType":"1","modelId":"1"},{"version":"2.8.0","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/Ft0_9d9ZtezzZt34HLkN-U3D_GgF","titleColor":"#a4c65f","subTitleColor":"#999999","directory":"app.paymentDetail","zoneCode":"0086","title":"缴费记录","moduleName":"缴费记录","appType":"1","modelId":"3","group":"公共服务","subTitle":"看看您的社保缴纳情况"},{"title":"医保网点","version":"2.8.0","subTitleColor":"#999999","titleColor":"#ee6f7a","zoneCode":"0086","moduleName":"医保网点","appType":"1","modelId":"8","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/FsIfCwjByONJ29RvHw0u9mhLG__7","group":"公共服务","subTitle":"查查医保定点医院和药店"},{"subTitle":"在线医生为您及时解答","group":"公共服务","titleColor":"#ff6600","title":"快速问诊","moduleName":"快速问诊","zoneCode":"0086","modelId":"21","version":"2.8.0","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/FgOvsvFckq9FpifRosky1uLs3xNC","subTitleColor":"#999999","appType":"1"},{"version":"2.8.0","subTitleColor":"#999999","moduleName":"工伤赔付","title":"工伤赔付","group":"公共服务","subTitle":"足不出户知进度","appType":"1","modelId":"20","zoneCode":"0086","titleColor":"#a4c65f","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/FmndCKdbPMVUGifNQmTpjSDXIbQ6","directory":"app.injuryCmpt"},{"group":"公共服务","subTitle":"办理社保业务前要准备什么","version":"2.8.0","titleColor":"#35c7fa","directory":"app.newsletterPage","subTitleColor":"#999999","param":"","moduleName":"办事指南","modelId":"7","appType":"1","zoneCode":"0086","title":"办事指南","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/FvIymwq_toIL2lPXG8F5VVcNZBZy"},{"param":"","version":"2.8.0","moduleName":"社保政策","group":"公共服务","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/FhBEpbltMPpUiok-H86PYw3YQIk0","modelId":"6","titleColor":"#ffc600","zoneCode":"0086","subTitle":"了解社保政策动态","directory":"app.socialSecurity","appType":"1","subTitleColor":"#999999","title":"社保政策"},{"subTitle":"了解社保政务动态","moduleName":"阳光政务","appType":"1","subTitleColor":"#999999","titleColor":"#ffc600","title":"阳光政务","group":"公共服务","zoneCode":"0086","modelId":"5","directory":"app.sunshine","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/FspFWCn5tZ5OpwjmDEbT1nzTc50F","version":"2.8.0"},{"modelId":"4","appType":"1","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/Fh84nEhG-xGBF53GfXyJ-LxLKVbM","titleColor":"#ff6600","version":"2.8.0","directory":"app.recruit","title":"招聘公示","zoneCode":"0086","subTitleColor":"#999999","moduleName":"招聘公示","group":"公共服务","subTitle":"就业局、人才市场招聘信息"},{"title":"医保缴费","zoneCode":"0086","subTitle":"居民医保在线缴费","version":"2.8.0","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/FpYG85nWIBUBrFAmwZbbDLLy6J15","moduleNum":"2","appType":"1","modelId":"16","moduleName":"医保缴费","group":"本地服务","titleColor":"#62666D","directory":"app.stuInsIntroduce","subTitleColor":"#999999"},{"subTitleColor":"#999999","moduleNum":"","subTitle":"肿瘤问题名医在线解答","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/Fi7OjOhMxOlmfuUenjdmqUDBn3dF","titleColor":"#62666D","title":"重疾问诊","appType":"1","zoneCode":"0086","group":"公共服务","modelId":"31","directory":"","moduleName":"重疾问诊","version":"2.8.0"},{"subTitleColor":"#999999","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/Fss2JCf4wv24Ymkd2EB9BeMnxk4Z","modelId":"13","version":"2.8.0","appType":"1","subTitle":"社保缴费情况","directory":"app.stuInsIndex","moduleNum":"2","title":"缴费记录","zoneCode":"0086","titleColor":"#62666D","group":"本地服务","moduleName":"缴费查询"},{"zoneCode":"0086","titleColor":"#62666D","version":"2.8.0","modelId":"9","group":"公共服务","moduleName":"常见问答","appType":"1","title":"常见问答","directory":"app.question","subTitle":"常见问题解答","subTitleColor":"#999999","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/Fr6QabuBP4vHZGfVPdkAEecmWP77","moduleNum":""},{"directory":"app.citizenCard","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/Fsxcps57hBVf54J9_dM_oK7CC-SD","opener":"","group":"本地服务","subTitle":"社会保障市民卡","zoneCode":"0086","appType":"1","moduleNum":"2","subTitleColor":"#999999","modelId":"11","title":"市民卡","moduleName":"社会保障","version":"2.8.0","titleColor":"#62666D"},{"title":"体检服务","subTitleColor":"#999999","appType":"1","group":"公共服务","subTitle":"在线为您预约体检","zoneCode":"0086","moduleName":"体检服务","titleColor":"#a4c65f","version":"2.8.0","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/FqTvYZumrqVT9HQ8UHXEdfe2E0mY","modelId":"50","moduleNum":"","directory":"app.ndIndex"},{"version":"2.8.0","moduleNum":"","moduleName":"投票专区","titleColor":"#ffc600","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/FqPvznPikOL5V1oVkIQpeBes76h7","group":"公共服务","subTitle":"参与投票 选出真爱","zoneCode":"0086","appType":"1","title":"投票专区","directory":"","subTitleColor":"#999999","modelId":"98"}],"bottomPictures":[{"imageName":"常见问答(新农合)","imageID":"6","imageClickType":"Client","zoneCode":"0086","version":"2.8.0","opener":"app","imageClickURL":"app.FAQs","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/FuqzcXficXpWlTzkeSQsDoOE1mms","appType":"2"}],"bottomIcons":[],"zoneCode":"0086","zoneCode_desc":"全国"}
     * zoneCode : null
     */

    public Object page;
    public BodyBean body;
    public Object zoneCode;

    public static class BodyBean {
        /**
         * pictures : [{"version":"2.8.0","imageClickType":"client","opener":"app","appType":"2","imageID":"9","imageName":"上线了(新农合)","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/FuzT4cYLL9-3xMmefYuTPTk0cjRN","zoneCode":"0086"},{"imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/FmiPlUmpatp_O4IHsf8Dckhk9Avo","opener":"app","imageID":"1","zoneCode":"0086","imageClickType":"client","appType":"1","version":"2.8.0","imageName":"上线了"},{"imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/FiUqC1Da908Xn0WFO984d1DoSKhr","imageID":"3","imageName":"医保帐户","opener":"app","imageClickType":"client","version":"2.8.0","appType":"2","zoneCode":"0086","imageClickURL":"25"},{"appType":"1","opener":"app","imageID":"2","imageClickType":"client","imageClickURL":"17","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/FuzU-sII1ntcrWi0Rr598fu66m22","imageName":"健康档案","version":"2.8.0","zoneCode":"0086"},{"imageClickType":"client","zoneCode":"0086","imageUrl":"http://7xrraa.com1.z0.glb.clouddn.com/leping03.png","imageID":"6","imageClickURL":"23","version":"2.8.0","imageName":"慢病随访","appType":"2","opener":"app"},{"opener":"app","imageID":"3","version":"2.8.0","zoneCode":"0086","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/FofJxg4NTQx23QFCC6ECBUlw15gs","imageClickType":"client","appType":"1","imageName":"医保帐户","imageClickURL":"1"},{"imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/Flt9E-VCcaIdY1ma68-m4VLzo_iD","imageClickURL":"40","opener":"app","version":"2.8.0","imageID":"15","imageName":"签到有礼","zoneCode":"0086","imageClickType":"client","appType":"1"}]
         * indexConfig : [{"titleColor":"#333333","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/Fj0P74cR-gW-l-HlUMBU7r71w1Oo","group":"公共服务","directory":"app.drugExpense","subTitleColor":"#666666","appType":"2","moduleName":"报销目录","modelId":"19","version":"2.8.0","zoneCode":"0086","title":"报销目录","subTitle":"看看你的药品能否报销","moduleNum":"2"},{"subTitle":"医疗健康  资讯信息","titleColor":"#333333","modelId":"40","appType":"2","version":"2.8.0","title":"资讯中心","group":"公共服务","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/FoULQGOL2FNbgNDMVnttmnT4UJ-D","zoneCode":"0086","moduleNum":"2","directory":"app.inqueryCenter","moduleName":"资讯中心(新农合)","subTitleColor":"#666666"},{"subTitleColor":"#666666","subTitle":"政策动态 权威解读","titleColor":"#333333","directory":"app.newsletterPage","modelId":"39","moduleNum":"2","title":"政策解读","group":"公共服务","moduleName":"政策解读（新农合）","zoneCode":"0086","appType":"2","version":"2.8.0","param":"1","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/Fj_sc0Te8LnZwj74PHl_R-r5gTa1"},{"moduleNum":"2","directory":"app.treatQuery","moduleName":"待遇查询（新农合）","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/Fsp5FNUfwgnBSFh3IYNz40cY4DZx","modelId":"37","param":"","subTitle":"报销待遇 便捷速查","group":"公共服务","subTitleColor":"#666666","title":"待遇查询","appType":"2","version":"2.8.0","titleColor":"#333333","zoneCode":"0086"},{"subTitleColor":"#666666","moduleNum":"2","appType":"2","version":"2.8.0","titleColor":"#333333","modelId":"38","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/FlfziBN8pzdTLmCbb3_iUoXf-fHj","directory":"app.notices","moduleName":"消息公告（新农合）","zoneCode":"0086","group":"公共服务","subTitle":"最新资讯 即刻送达","title":"消息公告"},{"appType":"2","subTitleColor":"#666666","subTitle":"比例确定 报销明晰","moduleName":"报销比例（新农合）","zoneCode":"0086","version":"2.8.0","modelId":"35","group":"公共服务","moduleNum":"2","titleColor":"#333333","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/Fv1OPRNrbia7kD8KxBitbIUKJCHn","directory":"app.reimbursePercent","title":"报销比例"},{"modelId":"33","version":"2.8.0","moduleNum":"","group":"公共服务","appType":"1","zoneCode":"0086","directory":"","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/Fl846eNfHBJ_V3YCS3FdisHJRUaa","subTitle":"便捷生活小助手","titleColor":"#a4c65f","subTitleColor":"#999999","moduleName":"生活服务","title":"生活服务"},{"group":"公共服务","directory":"app.accountSearch","version":"2.8.0","title":"医保账户","subTitleColor":"#999999","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/FosqaSlscvns7ELXGKcaDE_z5SQ7","zoneCode":"0086","subTitle":"看看医保卡上还有多少钱","moduleName":"医保账户","titleColor":"#36b293","appType":"1","modelId":"1"},{"version":"2.8.0","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/Ft0_9d9ZtezzZt34HLkN-U3D_GgF","titleColor":"#a4c65f","subTitleColor":"#999999","directory":"app.paymentDetail","zoneCode":"0086","title":"缴费记录","moduleName":"缴费记录","appType":"1","modelId":"3","group":"公共服务","subTitle":"看看您的社保缴纳情况"},{"title":"医保网点","version":"2.8.0","subTitleColor":"#999999","titleColor":"#ee6f7a","zoneCode":"0086","moduleName":"医保网点","appType":"1","modelId":"8","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/FsIfCwjByONJ29RvHw0u9mhLG__7","group":"公共服务","subTitle":"查查医保定点医院和药店"},{"subTitle":"在线医生为您及时解答","group":"公共服务","titleColor":"#ff6600","title":"快速问诊","moduleName":"快速问诊","zoneCode":"0086","modelId":"21","version":"2.8.0","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/FgOvsvFckq9FpifRosky1uLs3xNC","subTitleColor":"#999999","appType":"1"},{"version":"2.8.0","subTitleColor":"#999999","moduleName":"工伤赔付","title":"工伤赔付","group":"公共服务","subTitle":"足不出户知进度","appType":"1","modelId":"20","zoneCode":"0086","titleColor":"#a4c65f","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/FmndCKdbPMVUGifNQmTpjSDXIbQ6","directory":"app.injuryCmpt"},{"group":"公共服务","subTitle":"办理社保业务前要准备什么","version":"2.8.0","titleColor":"#35c7fa","directory":"app.newsletterPage","subTitleColor":"#999999","param":"","moduleName":"办事指南","modelId":"7","appType":"1","zoneCode":"0086","title":"办事指南","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/FvIymwq_toIL2lPXG8F5VVcNZBZy"},{"param":"","version":"2.8.0","moduleName":"社保政策","group":"公共服务","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/FhBEpbltMPpUiok-H86PYw3YQIk0","modelId":"6","titleColor":"#ffc600","zoneCode":"0086","subTitle":"了解社保政策动态","directory":"app.socialSecurity","appType":"1","subTitleColor":"#999999","title":"社保政策"},{"subTitle":"了解社保政务动态","moduleName":"阳光政务","appType":"1","subTitleColor":"#999999","titleColor":"#ffc600","title":"阳光政务","group":"公共服务","zoneCode":"0086","modelId":"5","directory":"app.sunshine","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/FspFWCn5tZ5OpwjmDEbT1nzTc50F","version":"2.8.0"},{"modelId":"4","appType":"1","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/Fh84nEhG-xGBF53GfXyJ-LxLKVbM","titleColor":"#ff6600","version":"2.8.0","directory":"app.recruit","title":"招聘公示","zoneCode":"0086","subTitleColor":"#999999","moduleName":"招聘公示","group":"公共服务","subTitle":"就业局、人才市场招聘信息"},{"title":"医保缴费","zoneCode":"0086","subTitle":"居民医保在线缴费","version":"2.8.0","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/FpYG85nWIBUBrFAmwZbbDLLy6J15","moduleNum":"2","appType":"1","modelId":"16","moduleName":"医保缴费","group":"本地服务","titleColor":"#62666D","directory":"app.stuInsIntroduce","subTitleColor":"#999999"},{"subTitleColor":"#999999","moduleNum":"","subTitle":"肿瘤问题名医在线解答","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/Fi7OjOhMxOlmfuUenjdmqUDBn3dF","titleColor":"#62666D","title":"重疾问诊","appType":"1","zoneCode":"0086","group":"公共服务","modelId":"31","directory":"","moduleName":"重疾问诊","version":"2.8.0"},{"subTitleColor":"#999999","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/Fss2JCf4wv24Ymkd2EB9BeMnxk4Z","modelId":"13","version":"2.8.0","appType":"1","subTitle":"社保缴费情况","directory":"app.stuInsIndex","moduleNum":"2","title":"缴费记录","zoneCode":"0086","titleColor":"#62666D","group":"本地服务","moduleName":"缴费查询"},{"zoneCode":"0086","titleColor":"#62666D","version":"2.8.0","modelId":"9","group":"公共服务","moduleName":"常见问答","appType":"1","title":"常见问答","directory":"app.question","subTitle":"常见问题解答","subTitleColor":"#999999","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/Fr6QabuBP4vHZGfVPdkAEecmWP77","moduleNum":""},{"directory":"app.citizenCard","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/Fsxcps57hBVf54J9_dM_oK7CC-SD","opener":"","group":"本地服务","subTitle":"社会保障市民卡","zoneCode":"0086","appType":"1","moduleNum":"2","subTitleColor":"#999999","modelId":"11","title":"市民卡","moduleName":"社会保障","version":"2.8.0","titleColor":"#62666D"},{"title":"体检服务","subTitleColor":"#999999","appType":"1","group":"公共服务","subTitle":"在线为您预约体检","zoneCode":"0086","moduleName":"体检服务","titleColor":"#a4c65f","version":"2.8.0","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/FqTvYZumrqVT9HQ8UHXEdfe2E0mY","modelId":"50","moduleNum":"","directory":"app.ndIndex"},{"version":"2.8.0","moduleNum":"","moduleName":"投票专区","titleColor":"#ffc600","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/FqPvznPikOL5V1oVkIQpeBes76h7","group":"公共服务","subTitle":"参与投票 选出真爱","zoneCode":"0086","appType":"1","title":"投票专区","directory":"","subTitleColor":"#999999","modelId":"98"}]
         * bottomPictures : [{"imageName":"常见问答(新农合)","imageID":"6","imageClickType":"Client","zoneCode":"0086","version":"2.8.0","opener":"app","imageClickURL":"app.FAQs","imageUrl":"http://7xpvcw.com1.z0.glb.clouddn.com/FuqzcXficXpWlTzkeSQsDoOE1mms","appType":"2"}]
         * bottomIcons : []
         * zoneCode : 0086
         * zoneCode_desc : 全国
         */

        public String zoneCode;
        public String zoneCode_desc;
        public List<PicturesBean> pictures;
        public List<IndexConfigBean> indexConfig;
        public List<BottomPicturesBean> bottomPictures;
        public List<?> bottomIcons;

        public static class PicturesBean {
            /**
             * version : 2.8.0
             * imageClickType : client
             * opener : app
             * appType : 2
             * imageID : 9
             * imageName : 上线了(新农合)
             * imageUrl : http://7xpvcw.com1.z0.glb.clouddn.com/FuzT4cYLL9-3xMmefYuTPTk0cjRN
             * zoneCode : 0086
             * imageClickURL : 25
             */

            public String version;
            public String imageClickType;
            public String opener;
            public String appType;
            public String imageID;
            public String imageName;
            public String imageUrl;
            public String zoneCode;
            public String imageClickURL;
        }

        public static class IndexConfigBean {
            /**
             * titleColor : #333333
             * imageUrl : http://7xpvcw.com1.z0.glb.clouddn.com/Fj0P74cR-gW-l-HlUMBU7r71w1Oo
             * group : 公共服务
             * directory : app.drugExpense
             * subTitleColor : #666666
             * appType : 2
             * moduleName : 报销目录
             * modelId : 19
             * version : 2.8.0
             * zoneCode : 0086
             * title : 报销目录
             * subTitle : 看看你的药品能否报销
             * moduleNum : 2
             * param : 1
             * opener :
             */

            public String titleColor;
            public String imageUrl;
            public String group;
            public String directory;
            public String subTitleColor;
            public String appType;
            public String moduleName;
            public String modelId;
            public String version;
            public String zoneCode;
            public String title;
            public String subTitle;
            public String moduleNum;
            public String param;
            public String opener;
        }

        public static class BottomPicturesBean {
            /**
             * imageName : 常见问答(新农合)
             * imageID : 6
             * imageClickType : Client
             * zoneCode : 0086
             * version : 2.8.0
             * opener : app
             * imageClickURL : app.FAQs
             * imageUrl : http://7xpvcw.com1.z0.glb.clouddn.com/FuqzcXficXpWlTzkeSQsDoOE1mms
             * appType : 2
             */

            public String imageName;
            public String imageID;
            public String imageClickType;
            public String zoneCode;
            public String version;
            public String opener;
            public String imageClickURL;
            public String imageUrl;
            public String appType;
        }
    }
}
