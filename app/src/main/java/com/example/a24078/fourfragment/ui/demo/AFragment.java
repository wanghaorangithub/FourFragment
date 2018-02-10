package com.example.a24078.fourfragment.ui.demo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a24078.fourfragment.R;
import com.example.a24078.fourfragment.ui.base.BaseFragment;


/**
 * Created by 24078 on 2018/1/29.
 */

public class AFragment extends BaseFragment {
    private FragmentSwitcher fragmentSwitcher;

    //button click event
    private void buttonClickEvent() {
        fragmentSwitcher.switchToBFragment();
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_a;
    }

    @Override
    protected void created(Bundle bundle) {
        initView();
    }

    private void initView() {
        Button button = mFragment.findViewById(R.id.a_fgm_button1);
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

    static AFragment newInstance(FragmentSwitcher fragmentSwitcher) {
        AFragment aFragment = new AFragment();
        aFragment.setFragmentSwitcher(fragmentSwitcher);
        return aFragment;
    }

}
