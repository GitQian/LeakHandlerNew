package com.example.shengqian.leakhandlernew;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class SecondActivity extends AppCompatActivity {

    private TextView mHelloTv;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mHelloTv = (TextView) findViewById(R.id.tv_hello);
        mHandler.postDelayed(new DoRunAble(mHelloTv), 160000);
    }

    /**
     * 静态内部类
     */
    private static class DoRunAble implements Runnable {
        private WeakReference<TextView> mTextView;

        public DoRunAble(TextView textView) {
            mTextView = new WeakReference<TextView>(textView);
        }

        @Override
        public void run() {
            TextView textView = mTextView.get();
            if (textView != null) {
                textView.setText("十年后..");
            } else {
                Log.d("SecondActivity", "This view is null!");
            }
        }
    }
}
