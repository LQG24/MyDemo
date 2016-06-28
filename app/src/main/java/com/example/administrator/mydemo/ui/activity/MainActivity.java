package com.example.administrator.mydemo.ui.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.administrator.mydemo.R;
import com.example.administrator.mydemo.base.AbsBaseActivity;
import com.example.administrator.mydemo.ui.fragment.CustomWidgetFragment;
import com.example.administrator.mydemo.ui.fragment.ExpressionPackageFragment;
import com.example.administrator.mydemo.ui.fragment.HomeFragment;
import com.example.administrator.mydemo.ui.fragment.RxjavaDemoFragment;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;


public class MainActivity extends AbsBaseActivity {


    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.content)
    FrameLayout content;
    @Bind(R.id.nav_view)
    NavigationView mNavigationView;
    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;


    private HomeFragment homeFragment;
    private ExpressionPackageFragment expressionPackageFragment;
    private RxjavaDemoFragment rxjavaDemoFragment;
    private Fragment[] fragments;
    private int currentTabIndex;
    private int index;
    private CustomWidgetFragment customWidgetFragment;

    private List<String> titles= Arrays.asList("Android", "iOS", "前端", "拓展资源", "休息视频","瞎推荐");

    public static HomeFragment newInstace()
    {
        return new HomeFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home: //对用户按home icon的处理
                mDrawerLayout.openDrawer(GravityCompat.END);
                return true;
            default:break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        if (mNavigationView != null)
        {
            setupDrawerContent(mNavigationView);
        }
        expressionPackageFragment = ExpressionPackageFragment.newInstance();
        homeFragment = HomeFragment.newInstance();
        rxjavaDemoFragment = RxjavaDemoFragment.newInstance();
        customWidgetFragment = CustomWidgetFragment.newInstance();

//        fragments = new android.app.Fragment[]{homeFragment, customWidgetFragment, rxjavaDemoFragment, expressionPackageFragment};
        fragments = new android.app.Fragment[]{homeFragment};
        getFragmentManager().beginTransaction().replace(R.id.content,homeFragment).commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }


    private void setupDrawerContent(NavigationView mNavigationView) {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.nav_home:
                        index = 0;
                        addFragment(fragments[0]);
                        menuItem.setChecked(true);
                        mToolbar.setTitle("Gank.IO");
                        mDrawerLayout.closeDrawers();
                        return true;

                    case R.id.nav_messages:
//                        index = 1;
//                        addFragment(fragments[1]);
                        mToolbar.setTitle("CustomWidget");
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        return true;

                    case R.id.nav_my_focus:
//                        index = 2;
//                        addFragment(fragments[2]);
                        menuItem.setChecked(true);
                        mToolbar.setTitle("RxJava");
                        mDrawerLayout.closeDrawers();
                        return true;

                    case R.id.nav_foucs_me:
//                        startActivity(new Intent(MainActivity.this, RecycleViewDemoActivity.class));
                        mDrawerLayout.closeDrawers();
                        return true;

                    case R.id.nav_article:
//                        index = 3;
//                        addFragment(fragments[3]);
                        menuItem.setChecked(true);
                        mToolbar.setTitle("AqualandFace");
                        mDrawerLayout.closeDrawers();
                        return true;

                    case R.id.nav_about:
//                        startActivity(new Intent(MainActivity.this , HotBitmapGGActivity.class));
                        break;

                    default:
                        break;
                }
                return true;

            }
        });
    }

    private void addFragment(Fragment fragment) {
        FragmentTransaction trx=getFragmentManager().beginTransaction();
        trx.hide(fragments[currentTabIndex]);
        if(!fragments[index].isAdded())
        {
            trx.add(R.id.content,fragments[index]);
        }
        trx.show(fragments[index]).commit();
        currentTabIndex=index;
    }

    @Override
    public void initToolBar() {
        mToolbar.setTitle("Gank.Io");
        setSupportActionBar(mToolbar);
        ActionBar mActionBar=getSupportActionBar();
        if(mActionBar!=null)
            mActionBar.setDisplayHomeAsUpEnabled(true);// 给左上角图标的左边加上一个返回的图标
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(MainActivity.this, mDrawerLayout, mToolbar, R.string.app_name, R.string.app_name);
        mDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mDrawerToggle);




    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        // TODO: add setContentView(...) invocation
//        ButterKnife.bind(this);
//    }
}
