package com.zn.lichen.lcdemo.widget;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.zn.lichen.lcdemo.R;

import java.util.ArrayList;
import java.util.Iterator;


public class FragmentTabHost extends RelativeLayout implements View.OnClickListener {
    public FrameLayout mFrameLayout;
    public LinearLayout mRelativeLayout;
    public Context mContext;
    public FragmentManager mFragmentManager;
    public boolean mAttached;
    public TabInfo mLastTab;
    public int mCurrentTab;
    public final ArrayList<TabInfo> mTabs = new ArrayList<>();
    public TabHostListener tabHostListener;

    /**
     * 回调接口
     */
    public interface TabHostListener {
        /**
         * 切换时触发
         */
        void onTabChange(int postion, String tag);

        /**
         * 点击时触发,返回true则进行fragment切换,false则不切换
         */
        boolean onTabClick(String tag);
    }
    /**
     * Tab信息类
     */
    public static final class TabInfo {
        public final String tag;
        public final Class<?> clss;
        public final Bundle args;
        public Fragment fragment;
        public final int indicatorResId;
        TabInfo(String _tag, Class<?> _class, Bundle _args, int _indicatorResId) {
            tag = _tag;
            clss = _class;
            args = _args;
            indicatorResId = _indicatorResId;
        }
    }

    public FragmentTabHost(Context context, AttributeSet attrs) {
        super(context, attrs);
        initFragmentTabHost();
    }
    @Override
    public void onClick(View v) {
        String tag = (String) v.getTag();
        if (tabHostListener != null) {
            if (!tabHostListener.onTabClick(tag)) {
                return;
            }
        }
        setCurrentTabByTag(tag);
    }

    /**
     * 布局添加到window时
     */
    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mAttached = true;
        //是否是可以编辑模式
        if (isInEditMode()) {
            return;
        }
        String currentTab = getCurrentTabTag();
        FragmentTransaction transaction = null;
        for (int i = 0; i < mTabs.size(); i++) {
            TabInfo tab = mTabs.get(i);
            tab.fragment = mFragmentManager.findFragmentByTag(tab.tag);
            //当前fragment对象存在,并且没有脱离UI界面
            if (tab.fragment != null && !tab.fragment.isDetached()) {
                if (tab.tag.equals(currentTab)) {
                    mLastTab = tab;
                } else {
                    if (transaction == null) {
                        transaction = mFragmentManager.beginTransaction();
                    }
                    transaction.detach(tab.fragment);
                    tab.fragment = null;
                }
            }
        }
        //添加tag对应fragment到UI界面
        transaction = doTabChanged(currentTab, transaction);
        if (transaction != null) {
            transaction.commitAllowingStateLoss();
            mFragmentManager.executePendingTransactions();
        }
    }

    /**
     * 初始化变量
     */
    private void initFragmentTabHost() {
        mCurrentTab = -1;
    }
    /**
     * 添加Tab
     * @param tag Tab标记
     * @param clss 类
     * @param args 参数
     * @param indicatorResId 资源ID
     */
    public void addTab(String tag, Class<?> clss, Bundle args, int indicatorResId) {
        //生成Tab信息
        TabInfo info = new TabInfo(tag, clss, args, indicatorResId);
        //是否AttachedToWindow
        if (mAttached) {
            info.fragment = mFragmentManager.findFragmentByTag(tag);
            if (info.fragment != null && !info.fragment.isDetached()) {
                if (info.fragment.isVisible()) {
                    setCurrentTabByTag(tag);
                }
                FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                fragmentTransaction.detach(info.fragment);
                info.fragment = null;
                fragmentTransaction.commitAllowingStateLoss();
            }
        }
        //移除tag对应的Tab,使集合中不存在重复元素
        removeTag(tag);
        //添加TabInfo
        mTabs.add(info);
        //第一个被添加到集合中的布局默认选中显示
        if (mCurrentTab == -1) {
            mCurrentTab = 0;
            findViewById(indicatorResId).setSelected(true);
        }
        //打Tag
        findViewById(indicatorResId).setTag(tag);
        //设置监听事件
        findViewById(indicatorResId).setOnClickListener(this);
    }

    /**
     * 删除Tab
     * @param tag Tab标记
     * @return 是否删除成功
     */
    private boolean removeTag(String tag) {
        Iterator<TabInfo> iterator = mTabs.iterator();
        while (iterator.hasNext()) {
            TabInfo info = iterator.next();
            if (info.tag.equals(tag)) {
                iterator.remove();
                return true;
            }

        }
        return false;
    }

    /**
     * 检查布局是否合法.初始化相关对象
     * @param context 上下文对象
     * @param manager FragmentManager
     */
    public void setUp(Context context, FragmentManager manager) {
        mRelativeLayout = (LinearLayout) findViewById(R.id.tab_host_index);
        if (mRelativeLayout == null) {
            throw new RuntimeException("Your FragmentTabHost must have a RelativeLayout whose id attribute is 'R.id.tab_host'");
        }
        mFrameLayout = (FrameLayout) findViewById(R.id.tab_host_continar);
        if (mFrameLayout == null) {
            throw new RuntimeException("Your FragmentTabHost must have a FrameLayout whose id attribute is 'R.id.continar'");
        }
        mContext = context;
        mFragmentManager = manager;
    }


    /**
     * 根据参数tag设置当前选中Tab
     * @param tag 标签
     */
    public void setCurrentTabByTag(String tag) {
        int i;
        FragmentTransaction transaction = null;

        //得到相应transaction
        for (i = 0; i < mTabs.size(); i++) {
            if (mTabs.get(i).tag.equals(tag)) {
                transaction = doTabChanged(tag, null);
                mCurrentTab = i;
                break;
            }
        }

        if (transaction != null) {
            //提交事务
            transaction.commitAllowingStateLoss();
            //让事务立即执行
            mFragmentManager.executePendingTransactions();
            //调用回调接口
            if (tabHostListener != null) {
                tabHostListener.onTabChange(i, tag);
            }
            //改变底部栏的选中状态
            for (i = 0; i < mTabs.size(); i++) {
                if (mTabs.get(i).indicatorResId > 0) {
                    View tab = findViewById(mTabs.get(i).indicatorResId);
                    if (tab != null) {
                        if (mCurrentTab == i) {
                            findViewById(mTabs.get(i).indicatorResId).setSelected(true);
                        } else {
                            findViewById(mTabs.get(i).indicatorResId).setSelected(false);
                        }
                    }
                }
            }
        }
    }

    /**
     * Tag间切换
     * @param tabId id
     * @param transaction transaction
     * @return transaction 已经做相应操作的transaction
     */
    public FragmentTransaction doTabChanged(String tabId, FragmentTransaction transaction) {
        TabInfo newTab = null;
        for (TabInfo info : mTabs) {
            if (info.tag.equals(tabId)) {
                newTab = info;
            }
        }
        if (newTab == null) {
            throw new IllegalStateException("No tab known for tag " + tabId);
        }
        //当前Tag与将要切换的Tab不同,隐藏当前,显示将要切换的.
        if (mLastTab != newTab) {
            if (transaction == null) {
                transaction = mFragmentManager.beginTransaction();
            }
            if (mLastTab != null) {
                if (mLastTab.fragment != null) {
                    transaction.hide(mLastTab.fragment);
                }
            }
            if (newTab.fragment == null) {
                newTab.fragment = Fragment.instantiate(mContext, newTab.clss.getName(), newTab.args);
                //删除tag为newTab.tag的fragment
                deleteOldFragment(newTab.tag, transaction);
                transaction.add(R.id.tab_host_continar, newTab.fragment, newTab.tag);
            } else {
                transaction.show(newTab.fragment);
            }
            mLastTab = newTab;
        }
        return transaction;
    }


    /**
     * 根据Tag删除Fragment
     * @param tag 标记
     * @param transaction transaction
     */
    private void deleteOldFragment(String tag, FragmentTransaction transaction) {
        Fragment fragment = mFragmentManager.findFragmentByTag(tag);
        if (fragment != null) {
            transaction.remove(fragment);
        }
    }

    /**
     * 得到相对于的Tab的tag
     * @return tag
     */
    public String getCurrentTabTag() {
        if (mCurrentTab >= 0 && mCurrentTab < mTabs.size()) {
            return mTabs.get(mCurrentTab).tag;
        }
        return null;
    }

    /**
     * 设置监听回调对象
     * @param tabHostListener 回调对象
     */
    public void setTabHostListener(TabHostListener tabHostListener) {
        this.tabHostListener = tabHostListener;
    }
    public TabInfo getCurrentTab() {
        return mLastTab;
    }

    public TabHostListener getTabHostListener() {
        return tabHostListener;
    }
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mAttached = false;
    }
}
