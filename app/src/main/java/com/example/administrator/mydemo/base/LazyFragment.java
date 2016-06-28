package com.example.administrator.mydemo.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Created by Linqiaogeng on 2016/6/27.
 */
public abstract class LazyFragment extends Fragment{
    private View rootview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       rootview=inflater.inflate(getLayoutId(),container,false);
        return rootview;
    }

    public abstract int getLayoutId();

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this,view);
        initViews();
    }

    protected abstract void initViews();
}
