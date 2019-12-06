package com.xingwang.circleclouddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.xingwang.circle.CircleActivity;

public class MainActivity extends AppCompatActivity {

    protected TextView tv_jump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_jump=findViewById(R.id.tv_jump);

        tv_jump.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CircleActivity.getIntent(MainActivity.this);
            }
        });

    }
}
