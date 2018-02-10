package com.example.a24078.fourfragment.ui.demo;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.Button;

import com.example.a24078.fourfragment.R;
import com.example.a24078.fourfragment.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;


public class MainActivity extends BaseActivity implements FragmentSwitcher {

    @BindView(R.id.main_act_button1)
    Button button;

    @OnClick(R.id.main_act_button1)
    public void clickButton() {
        button.setText(R.string.main_act_string2);
    }

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
        aFragment = AFragment.newInstance(this);
        bFragment = BFragment.newInstance(this);
        cFragment = CFragment.newInstance(this);
        dFragment = DFragment.newInstance(this);
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

