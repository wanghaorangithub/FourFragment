package com.example.a24078.fourfragment.ui.main;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.a24078.fourfragment.R;

/**
 * Created by 24078 on 2018/1/29.
 */

public class Fragment2 extends Fragment {
    private Button button;
    private OnButtonClick onButtonClick;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        onButtonClick = (OnButtonClick) getActivity();
        View view = inflater.inflate(R.layout.fragment2_layout, null);
        button = (Button) view.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View view) {
                                          onButtonClick.switchTo1();
                                      }
                                  }
        );
        return inflater.inflate(R.layout.fragment2_layout, container, false);
    }

    public OnButtonClick getOnButtonClick() {
        return onButtonClick;
    }

    public void setOnButtonClick(OnButtonClick onButtonClick) {
        this.onButtonClick = onButtonClick;
    }
}