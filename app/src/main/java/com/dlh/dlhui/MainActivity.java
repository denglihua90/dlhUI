package com.dlh.dlhui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.dlh.ui.ReSpinner;

public class MainActivity extends AppCompatActivity {


    private Button loginPassEdit;
    private Button respinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        loginPassEdit = (Button) findViewById(R.id.login_pass_edit);
        loginPassEdit.setOnClickListener(onClickListener);
        respinner = (Button) findViewById(R.id.respinner);
        respinner.setOnClickListener(onClickListener);
    }

    protected View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.login_pass_edit:
                    LoginPasswordEditTextDemo.toLoginPasswordEditTextDemo(MainActivity.this);
                    break;
                case R.id.respinner:
                    ReSpinnerDemo.toReSpinnerDemo(MainActivity.this);
                    break;
            }
        }
    };
}
