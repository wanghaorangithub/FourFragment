package com.example.a24078.fourfragment.ui.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.a24078.fourfragment.R;

import butterknife.ButterKnife;

/**
 * Created by haoran on 2018/2/1.
 */

public abstract class BaseActivity extends AppCompatActivity{

    protected abstract
    @LayoutRes
    int layoutId();

    protected abstract void created(Bundle bundle);

    protected abstract void resumed();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId());
        ButterKnife.bind(this);
        created(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        resumed();
    }
}
