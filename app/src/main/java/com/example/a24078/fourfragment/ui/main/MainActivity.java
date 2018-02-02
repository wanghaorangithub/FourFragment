package com.example.a24078.fourfragment.ui.main;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.a24078.fourfragment.R;
import com.example.a24078.fourfragment.ui.base.BaseActivity;


public class MainActivity extends BaseActivity implements FragmentSwitcher {
    private AFragment AFragment;
    private BFragment BFragment;
    private CFragment CFragment;
    private DFragment DFragment;
    private FragmentManager fragmentManager;

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void created(Bundle bundle) {
        initView();
        switchTo1();
    }

    private void initView() {
        fragmentManager = getSupportFragmentManager();
        AFragment = new AFragment();
        AFragment.setFragmentSwitcher(this);
        BFragment = new BFragment();
        BFragment.setFragmentSwitcher(this);
        CFragment = new CFragment();
        CFragment.setFragmentSwitcher(this);
        DFragment = new DFragment();
        DFragment.setFragmentSwitcher(this);
    }

    @Override
    protected void resumed() {

    }

    @Override
    public void switchTo1() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, AFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void switchTo2() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, BFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void switchTo3() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, CFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void switchTo4() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, DFragment);
        fragmentTransaction.commit();
    }
}

