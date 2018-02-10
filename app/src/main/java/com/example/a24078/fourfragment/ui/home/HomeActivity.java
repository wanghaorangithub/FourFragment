package com.example.a24078.fourfragment.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.a24078.fourfragment.R;
import com.example.a24078.fourfragment.ui.base.BaseActivity;
import com.example.a24078.fourfragment.ui.demo.MainActivity;
import com.example.a24078.fourfragment.ui.objectBox.demo.NoteActivity;

import butterknife.BindView;
import butterknife.OnClick;



public class HomeActivity extends BaseActivity {
    @BindView(R.id.home_act_button1)
    Button button1;
    @BindView(R.id.home_act_button2)
    Button button2;
    @BindView(R.id.home_act_button3)
    Button button3;
    @BindView(R.id.home_act_button4)
    Button button4;

    @OnClick(R.id.home_act_button1)
    public void clickButton1() {
        Intent intent = new Intent(HomeActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.home_act_button2)
    public void clickButton2() {
        Intent intent = new Intent(HomeActivity.this, NoteActivity.class);
        startActivity(intent);
    }

    @OnClick(R.id.home_act_button3)
    public void clickButton3() {
        Toast.makeText(HomeActivity.this, "sorry,please click the first two button", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.home_act_button4)
    public void clickButton4() {
        Toast.makeText(HomeActivity.this, "sorry,please click the first two button", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected int layoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void created(Bundle bundle) {
    }

    @Override
    protected void resumed() {
    }
}
