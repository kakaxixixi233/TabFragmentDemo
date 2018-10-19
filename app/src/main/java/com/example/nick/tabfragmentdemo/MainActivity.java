package com.example.nick.tabfragmentdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;

    private FragmentPagerAdapter mAdapter;

    private List<Fragment> mFragments;
    private LinearLayout mTabWechat,mTabFace,mTabPerson;

    private ImageButton imgWechat,imgFace,imgPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initViews();
        initEvents();
        initDatas();
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            resetImgs();

            switch (v.getId()){
                case R.id.tab_wechat:
                    selectTab(0);
                    break;
                case R.id.tab_face:
                    selectTab(1);
                    break;
                case R.id.tab_person:
                    selectTab(2);
                    break;

            }
        }
    };


    private void initViews(){
        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);

        mTabWechat = (LinearLayout) findViewById(R.id.tab_wechat);
        mTabFace = (LinearLayout) findViewById(R.id.tab_face);
        mTabPerson = (LinearLayout) findViewById(R.id.tab_person);

        imgWechat= (ImageButton) findViewById(R.id.img_wechat);
        imgFace= (ImageButton) findViewById(R.id.img_face);
        imgPerson= (ImageButton) findViewById(R.id.img_person);

    }

    private void initEvents(){
        mTabWechat.setOnClickListener(onClickListener);
        mTabFace.setOnClickListener(onClickListener);
        mTabPerson.setOnClickListener(onClickListener);
    }

    private void initDatas(){
        mFragments = new ArrayList<>();

        mFragments.add(new FragmentWechat());
        mFragments.add(new FragmentFace());
        mFragments.add(new FragmentPerson());

        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }
        };
        //设置ViewPager的适配器
        mViewPager.setAdapter(mAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mViewPager.setCurrentItem(position);
                resetImgs();
        selectTab(position);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
});
    }

    private void selectTab(int i){
        switch (i){
            case 0:
                imgWechat.setImageResource(R.mipmap.chat2);
                break;
            case 1:
                imgFace.setImageResource(R.mipmap.face2);
                break;
            case 2:
                imgPerson.setImageResource(R.mipmap.person2);
                break;
        }
        mViewPager.setCurrentItem(i);

    }

    private void resetImgs(){
        imgWechat.setImageResource(R.mipmap.chat1);
        imgFace.setImageResource(R.mipmap.face1);
        imgPerson.setImageResource(R.mipmap.person1);


    }

}
