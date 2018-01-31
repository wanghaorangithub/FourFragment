package com.example.a24078.fourfragment;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity implements OnButtonClick {
    private Fragment1 fragment1;
    private Fragment2 fragment2;
    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getFragmentManager();
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
    }

    @Override
    public void swichTo2(View view) {
        fm.beginTransaction()
                .replace(R.id.fragment, fragment2)
                .commit();
    }
    @Override
    public void swichTo1(View view) {
        fm.beginTransaction()
                .replace(R.id.fragment, fragment1)
                .commit();
    }

}

