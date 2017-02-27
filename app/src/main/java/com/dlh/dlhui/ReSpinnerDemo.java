package com.dlh.dlhui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dlh.ui.ReSpinner;

/**
 * Created by dlh on 2017/2/23.
 */

public class ReSpinnerDemo extends AppCompatActivity {

    private ReSpinner respinner;

    public static void toReSpinnerDemo(Context context) {
        Intent intent = new Intent(context, ReSpinnerDemo.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.respinner_demo);
        initView();
    }

    private void initView() {
        respinner = (ReSpinner) findViewById(R.id.respinner);
    }
}
