package com.example.administrator.mydemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.mydemo.utils.StatusBarCompatUtil;

import butterknife.ButterKnife;

/**
 * Created by Linqiaogeng on 2016/6/26.
 */
public abstract class AbsBaseActivity extends AppCompatActivity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置布局内容
        setContentView(getLayoutId());
        //初始化黄油刀控件绑定框架
        ButterKnife.bind(this);
        //初始化控件
        initViews(savedInstanceState);
        //初始化ToolBar
        initToolBar();
        //适配4.4系统状态栏
        StatusBarCompatUtil.compat(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
    public abstract int getLayoutId();
    public abstract void initViews(Bundle savedInstanceState);
    public abstract void initToolBar();
}
