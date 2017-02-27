package com.dlh.dlhui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by dlh on 2017/2/8.
 */
public class LoginPasswordEditTextDemo extends AppCompatActivity {

    public static void toLoginPasswordEditTextDemo(Context context) {
        Intent intent = new Intent(context, LoginPasswordEditTextDemo.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_pass_edit_activity_layout);
    }
}
