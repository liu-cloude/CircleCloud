package com.xingwang.essay;

import android.content.Context;
import android.content.Intent;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.blankj.utilcode.util.EmptyUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.xingwang.essay.adapter.EssayListViewpagerAdapter;
import com.xingwang.essay.base.BaseActivity;
import com.xingwang.essay.fragment.EssayListFragment;
import com.xingwang.swip.title.TopTitleView;
import com.xingwang.swip.utils.Constants;
import com.xingwang.swip.utils.HttpUtil;
import com.xingwang.swip.utils.JsonUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 文章列表
 * */
public class EssayListActivity extends BaseActivity {

    protected TopTitleView title;
    protected TabLayout mTabLayout;
    protected ViewPager viewpager;

    private List<Fragment> mFragments=new ArrayList<>();
    private List<String> titleList=new ArrayList<>();

    private int pos=0;//默认页面index=0
    private String category;//默认页面index=0

    public static Intent getIntent(Context context) {
        Intent intent = new Intent(context, EssayListActivity.class);
        context.startActivity(intent);
        return intent;
    }

    public static Intent getIntent(Context context,String category) {
        Intent intent = new Intent(context, EssayListActivity.class);
        intent.putExtra(Constants.INTENT_DATA,category);
        context.startActivity(intent);
        return intent;
    }

    @Override
    public int getLayoutId() {
        return R.layout.essay_activity_essay_list;
    }

    @Override
    public void initData() {

        category=getIntent().getStringExtra(Constants.INTENT_DATA);

        HttpUtil.get(Constants.ESSAY_CATALOG, new HttpUtil.HttpCallBack() {
            @Override
            public void onFailure(String message) {
                ToastUtils.showShortSafe(message);
            }
            @Override
            public void onSuccess(String json) {
                List<String> titles= JsonUtils.jsonToList(json,String.class);

                if (EmptyUtils.isNotEmpty(titles)){
                    for (int i=0;i<titles.size();i++){

                        if (EmptyUtils.isNotEmpty(category)&&category.equals(titles.get(i))){
                            pos=i;
                        }

                        titleList.add(titles.get(i));
                        mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(i)));
                        mFragments.add(EssayListFragment.newInstance(titles.get(i)));
                    }
                    EssayListViewpagerAdapter mViewPagerAdapter = new EssayListViewpagerAdapter(getSupportFragmentManager(), mFragments,titleList);
                    viewpager.setAdapter(mViewPagerAdapter);
                    mTabLayout.setupWithViewPager(viewpager);
                    viewpager.setCurrentItem(pos);
                }
            }
        });
    }

    @Override
    protected void initView() {
        title = (TopTitleView) findViewById(R.id.title);
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewpager = (ViewPager) findViewById(R.id.viewpager);

        mTabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.reslib_colorPrimary));

        title.setTitleText("文章列表");
    }
}
