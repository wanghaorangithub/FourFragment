package com.example.a24078.fourfragment;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;



public class MainActivity extends AppCompatActivity  {
    private Fragment1 fragment1 = new Fragment1();
    private Fragment2 fragment2 = new Fragment2();
    FragmentManager fm = getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment1.setOnButtonClick(new OnButtonClick() {
            @Override
            public void onClick(View view) {
                fm.beginTransaction()
                        .replace(R.id.fragment, new Fragment2())
                        .commit();
            }
        });

        fragment2.setOnButtonClick(new OnButtonClick() {
            @Override
            public void onClick(View view) {
                fm.beginTransaction()
                        .replace(R.id.fragment, new Fragment1())
                        .commit();
            }
        });
    }
}

