package com.xingwang.circleclouddemo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.xingwang.circle.CardDetailActivity;
import com.xingwang.circle.utils.CacheUtils;
import com.xingwang.groupchat.GroupListActivity;


public class MainActivity extends AppCompatActivity {

    protected TextView tv_jump_circle_uri;
    protected TextView tv_jump_essay_uri;

    protected TextView tv_jump_circle;
    protected TextView tv_jump_essay;

    protected TextView tv_jump_groupchat;
    protected TextView tv_clear_cache;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_jump_circle=findViewById(R.id.tv_jump_circle);
        tv_jump_essay=findViewById(R.id.tv_jump_essay);

        tv_jump_circle_uri=findViewById(R.id.tv_jump_circle_uri);
        tv_jump_essay_uri=findViewById(R.id.tv_jump_essay_uri);

        tv_clear_cache=findViewById(R.id.tv_clear_cache);
        tv_jump_groupchat=findViewById(R.id.tv_jump_groupchat);

        Uri circleUri = Uri.parse("circle://com.xingwang.circleclouddemo.host.card?id=56");
        Intent circleIntent = new Intent(Intent.ACTION_VIEW,circleUri);

        Uri essayUri = Uri.parse("essay://com.xingwang.circleclouddemo.host.adessay?url=http://zyapp.test.xw518.com/article/859");
        Intent essayIntent = new Intent(Intent.ACTION_VIEW,essayUri);

        Uri essaylistUri = Uri.parse("essay://com.xingwang.circleclouddemo.host.essaylist?tag=1");
        Intent essaylistIntent = new Intent(Intent.ACTION_VIEW,essaylistUri);

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
                CardDetailActivity.getIntent(MainActivity.this,"180");
            }
        });

        tv_jump_essay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //EssayListActivity.getIntent(MainActivity.this);
                startActivity(essaylistIntent);
            }
        });

        tv_jump_groupchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GroupListActivity.getIntent(MainActivity.this);
            }
        });

        tv_clear_cache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CacheUtils.clearCache();
                Toast.makeText(MainActivity.this,"删除了",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
