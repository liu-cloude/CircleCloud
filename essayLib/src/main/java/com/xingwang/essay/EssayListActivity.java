package com.xingwang.essay;

import android.content.Context;
import android.content.Intent;

import android.net.Uri;
import android.os.AsyncTask;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.blankj.utilcode.util.EmptyUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.xingwang.essay.adapter.EssayListViewpagerAdapter;
import com.xingwang.essay.base.BaseActivity;
import com.xingwang.essay.bean.Essay;
import com.xingwang.essay.bean.EssayTitle;
import com.xingwang.essay.fragment.EssayListFragment;
import com.xingwang.swip.title.TopTitleView;
import com.xingwang.swip.utils.AsyncTaskUtils;
import com.xingwang.swip.utils.Constants;
import com.xingwang.swip.utils.HttpUtil;
import com.xingwang.swip.utils.JsonUtils;
import com.xingwang.swip.utils.asynctask.IDoInBackground;
import com.xingwang.swip.utils.asynctask.IPublishProgress;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 文章列表
 * */
public class EssayListActivity extends BaseActivity {

    protected TopTitleView title;
    protected TabLayout mTabLayout;
    protected ViewPager viewpager;

    private List<Fragment> mFragments=new ArrayList<>();
    private List<EssayTitle> titleList=new ArrayList<>();
    //排序后的标题
    private List<EssayTitle> arrayTitleList=new ArrayList<>();

    private AsyncTaskUtils.Builder<Void, Void, Void> mAsyncTask;

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
    protected void initView() {
        title =  findViewById(R.id.title);
        mTabLayout = findViewById(R.id.tabLayout);
        viewpager = findViewById(R.id.viewpager);

        mTabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.reslib_colorPrimary));

        title.setTitleText("文章列表");
    }

    @Override
    public void initData() {

        category=getIntent().getStringExtra(Constants.INTENT_DATA);

        if (EmptyUtils.isEmpty(category)){
            Uri uri=getIntent().getData();
            if (EmptyUtils.isNotEmpty(uri)){
                category=uri.getQueryParameter("tag");
            }
        }

        HttpUtil.get(Constants.ESSAY_CATALOG, new HttpUtil.HttpCallBack() {
            @Override
            public void onFailure(String message) {
                ToastUtils.showShortSafe(message);
            }
            @Override
            public void onSuccess(String json) {
                titleList.clear();
                arrayTitleList.clear();
                titleList= JsonUtils.jsonToList(json,EssayTitle.class);

                if (EmptyUtils.isEmpty(titleList)){
                    ToastUtils.showShortSafe("无标题数据!");
                    return;
                }

                mAsyncTask = AsyncTaskUtils.<Void, Void, Void>newBuilder().setDoInBackground(new IDoInBackground<Void, Void, Void>() {
                    @Override
                    public Void doInBackground(IPublishProgress<Void> publishProgress, Void... booleans) {
                        Iterator<EssayTitle> iterator = titleList.iterator();
                        while (iterator.hasNext()){
                            EssayTitle essayTitle=iterator.next();
                            if (essayTitle.isTop()){
                                arrayTitleList.add(essayTitle);
                                iterator.remove();
                            }
                        }

                        for (EssayTitle essayTitle:arrayTitleList){
                            essayTitleCast(titleList,essayTitle);
                        }

                        return null;
                    }
                }).setPostExecute(aBoolean -> {
                    for (EssayTitle essayTitle:arrayTitleList){

                      /*  if (EmptyUtils.isNotEmpty(category)&&category.equals(titles.get(i))){
                            pos=i;
                        }
                        titleList.add(titles.get(i));*/
                        mTabLayout.addTab(mTabLayout.newTab().setText(essayTitle.getTitle()));
                        mFragments.add(EssayListFragment.newInstance(essayTitle.getTitle()));
                    }

                    EssayListViewpagerAdapter mViewPagerAdapter = new EssayListViewpagerAdapter(getSupportFragmentManager(), mFragments,arrayTitleList);
                    viewpager.setAdapter(mViewPagerAdapter);
                    mTabLayout.setupWithViewPager(viewpager);
                    viewpager.setCurrentItem(pos);
                });
                mAsyncTask.start();
            }
        });
    }

    /**
     * 文章标题分配
     * @param remianDataList 未匹配的团队集合
     * @param parentTitle 上一层级集合
     * */
    public void essayTitleCast(List<EssayTitle> remianDataList,EssayTitle parentTitle){
        if (EmptyUtils.isNotEmpty(remianDataList)){
            Iterator<EssayTitle> iterator=remianDataList.iterator();
            List<EssayTitle> childTitles=new ArrayList<>();
            while (iterator.hasNext()){
                EssayTitle essayTitle=iterator.next();
                if (parentTitle.getId()==essayTitle.getPid()){
                    childTitles.add(essayTitle);
                    iterator.remove();
                }
            }
            parentTitle.setChildTitles(childTitles);

            if (EmptyUtils.isNotEmpty(remianDataList)){
                for (EssayTitle essayTitle:childTitles){
                    essayTitleCast(remianDataList,essayTitle);
                }
            }
        }
    }
}
