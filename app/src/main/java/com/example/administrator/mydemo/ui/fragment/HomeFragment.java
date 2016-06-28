package com.example.administrator.mydemo.ui.fragment;


import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.mydemo.R;
import com.example.administrator.mydemo.base.LazyFragment;
import com.flyco.tablayout.SlidingTabLayout;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 主界面
 * gank.io的Api
 * <p/>
 * 福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
 */
public class HomeFragment extends LazyFragment {
    @Bind(R.id.sliding_tabs)
    SlidingTabLayout mSlidingTabLayout;
    @Bind(R.id.tab_pager)
    ViewPager mViewPager;

    private List<String> titles = Arrays.asList("Android", "iOS", "前端", "拓展资源", "休息视频","瞎推荐");
    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initViews() {
        mViewPager.setAdapter(new TabPagerAdapter(getChildFragmentManager()));

    }

    public static HomeFragment newInstance()
    {

        return new HomeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    private class TabPagerAdapter extends FragmentPagerAdapter {


        public TabPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
//            return GankFragment.newInstance(titles.get(position));
            super.getItem(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }

        @Override
        public int getCount() {
            return titles.size();
        }
    }
}
