package com.example.a24078.fourfragment.ui.main;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.a24078.fourfragment.R;
import com.example.a24078.fourfragment.ui.base.BaseActivity;


public class MainActivity extends BaseActivity implements FragmentSwitcher {
    private AFragment aFragment;
    private BFragment bFragment;
    private CFragment cFragment;
    private DFragment dFragment;
    private FragmentManager fragmentManager;

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void created(Bundle bundle) {
        initView();
        switchToAFragment();
    }

    private void initView() {
        fragmentManager = getSupportFragmentManager();
        aFragment = AFragment.newIntance(this);
        bFragment = BFragment.newIntance(this);
        cFragment = CFragment.newIntance(this);
        dFragment = DFragment.newIntance(this);
    }

    @Override
    protected void resumed() {

    }

    @Override
    public void switchToAFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, aFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void switchToBFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, bFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void switchToCFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, cFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void switchToDFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, dFragment);
        fragmentTransaction.commit();
    }
}

