package com.example.a24078.fourfragment.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a24078.fourfragment.R;
import com.example.a24078.fourfragment.ui.base.BaseFragment;

/**
 * Created by 24078 on 2018/1/29.
 */

public class BFragment extends BaseFragment {
    private FragmentSwitcher fragmentSwitcher;

    //button click event
    private void buttonClickEvent() {
        fragmentSwitcher.switchTo3();
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_b;
    }

    @Override
    protected void created(Bundle bundle) {
        initView();
    }

    private void initView() {
        Button button = mFragment.findViewById(R.id.b_fgm_button1);
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

}
