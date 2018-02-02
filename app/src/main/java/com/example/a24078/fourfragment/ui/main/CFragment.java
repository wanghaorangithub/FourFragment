package com.example.a24078.fourfragment.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a24078.fourfragment.R;
import com.example.a24078.fourfragment.ui.base.BaseFragment;

/**
 * Created by 24078 on 2018/1/29.
 */

public class CFragment extends BaseFragment {
    private FragmentSwitcher fragmentSwitcher;

    //button click event
    private void buttonClickEvent() {
        fragmentSwitcher.switchToDFragment();
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_c;
    }

    @Override
    protected void created(Bundle bundle) {
        initView();
    }

    private void initView() {
        Button button = mFragment.findViewById(R.id.c_fgm_button1);
        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          buttonClickEvent();
                                      }


                                  }
        );
    }

    @Override
    protected void resumed() {

    }

    public void setFragmentSwitcher(FragmentSwitcher fragmentSwitcher) {
        this.fragmentSwitcher = fragmentSwitcher;
    }

    static CFragment newIntance(FragmentSwitcher fragmentSwitcher) {
        CFragment cFragment = new CFragment();
        cFragment.setFragmentSwitcher(fragmentSwitcher);
        return cFragment;
    }
}

