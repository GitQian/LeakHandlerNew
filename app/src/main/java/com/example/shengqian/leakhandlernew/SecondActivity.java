package com.example.shengqian.leakhandlernew;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView mHelloTv;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mHelloTv = (TextView) findViewById(R.id.tv_hello);
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Handler将会一直持有Activity的引用！
                mHelloTv.setText("十年后..");
            }
        }, 160000);
    }
}
