package com.example.shengqian.leakhandlernew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mJumpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mJumpBtn = (Button) findViewById(R.id.btn_jump);
        mJumpBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_jump:
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                break;

            default:
                break;
        }
    }
}
