package com.xingwang.circleclouddemo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.xingwang.circle.CircleActivity;
import com.xingwang.circle.PartSelctActivity;
import com.xingwang.essay.EssayListActivity;
import com.xingwang.essay.EssayWebviewActivity;

public class MainActivity extends AppCompatActivity {

    protected TextView tv_jump_circle_uri;
    protected TextView tv_jump_essay_uri;

    protected TextView tv_jump_circle;
    protected TextView tv_jump_essay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_jump_circle=findViewById(R.id.tv_jump_circle);
        tv_jump_essay=findViewById(R.id.tv_jump_essay);

        tv_jump_circle_uri=findViewById(R.id.tv_jump_circle_uri);
        tv_jump_essay_uri=findViewById(R.id.tv_jump_essay_uri);

        Uri circleUri = Uri.parse("circle://com.xingwang.circleclouddemo.host.card?id=56");
        Intent circleIntent = new Intent(Intent.ACTION_VIEW,circleUri);

        Uri essayUri = Uri.parse(" essay://com.xingwang.circleclouddemo.host.adessay?url=http://zyapp.test.xw518.com/article/859");
        Intent essayIntent = new Intent(Intent.ACTION_VIEW,essayUri);

        tv_jump_circle_uri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(circleIntent);
            }
        });

        tv_jump_essay_uri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(essayIntent);
            }
        });

        tv_jump_circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               PartSelctActivity.getIntent(MainActivity.this,500);
            }
        });

        tv_jump_essay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EssayListActivity.getIntent(MainActivity.this);
            }
        });
    }
}
