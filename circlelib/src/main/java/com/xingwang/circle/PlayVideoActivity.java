package com.xingwang.circle;

import android.content.Context;
import android.content.Intent;

import com.blankj.utilcode.util.EmptyUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.xingwang.circle.base.BaseActivity;
import com.xingwang.swip.utils.Constants;
import com.xingwang.swip.utils.ActivityManager;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

public class PlayVideoActivity extends BaseActivity {

    protected JzvdStd jzt_video;
    private String videoUrl;

    public static Intent getIntent(Context context, String videoPath) {
        Intent intent = new Intent(context, PlayVideoActivity.class);
        intent.putExtra(Constants.INTENT_DATA, videoPath);
        context.startActivity(intent);
        return intent;
    }

    @Override
    public int getLayoutId() {
        return R.layout.circle_activity_play_video;
    }

    @Override
    protected void initView() {
        jzt_video=findViewById(R.id.jzt_video);
    }

    @Override
    public void initData() {
        videoUrl =  getIntent().getStringExtra(Constants.INTENT_DATA);
        jzt_video.backButton.setOnClickListener(v -> ActivityManager.getInstance().finishActivity());

       // GlideUtils.loadPic(cardBody.getCover(),jzt_video.thumbImageView,PlayVideoActivity.this);

        if (EmptyUtils.isNotEmpty(videoUrl)){
            jzt_video.setUp(videoUrl,"", Jzvd.NORMAL_ORIENTATION);
            jzt_video.setScreenFullscreen();
        }else {
            ToastUtils.showShort("视频地址获取失败！");
            finish();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Jzvd.resetAllVideos();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
