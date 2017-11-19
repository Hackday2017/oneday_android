package com.muxistudio.oneday.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.muxistudio.oneday.R;
import com.muxistudio.oneday.base.BaseActivity;
import com.muxistudio.oneday.ui.chart.StatisticFragment;
import com.muxistudio.oneday.util.FragmentUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.iv_main)
    ImageView mIvMain;
    @BindView(R.id.main_btn_layout)
    LinearLayout mMainBtnLayout;
    @BindView(R.id.iv_statistic)
    ImageView mIvStatistic;
    @BindView(R.id.statistic_btn_layout)
    LinearLayout mStatisticBtnLayout;
    @BindView(R.id.layout_bottom)
    LinearLayout mLayoutBottom;

    private View mLastSelectedView;

    private DiaryListFragment mDiaryListFragment;
    private StatisticFragment mStatisticFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initFragment();
        initView();

    }

    private void initFragment() {
        mDiaryListFragment = (DiaryListFragment) FragmentUtils.addFragment(this,DiaryListFragment.class,null,R.id.main_container,false);
        mStatisticFragment = (StatisticFragment) FragmentUtils.addFragment(this,StatisticFragment.class,null,R.id.main_container,false);
        FragmentUtils.hideFragment(mStatisticFragment,this);
    }

    private void initView() {
        mMainBtnLayout.setSelected(true);
        mLastSelectedView = mMainBtnLayout;
        mMainBtnLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onViewSelected(view);
            }
        });
        mStatisticBtnLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onViewSelected(view);
            }
        });

    }

    private void onViewSelected(View view) {
        int id = view.getId();
        if (id == R.id.main_btn_layout){
            mLastSelectedView = mMainBtnLayout;
            mLastSelectedView.setSelected(true);
            FragmentUtils.hideFragment(mStatisticFragment,this);
            FragmentUtils.showFragment(mDiaryListFragment,this);
        }else if (id == R.id.statistic_btn_layout){
            mLastSelectedView = mStatisticBtnLayout;
            mLastSelectedView.setSelected(true);
            FragmentUtils.hideFragment(mDiaryListFragment,this);
            FragmentUtils.showFragment(mStatisticFragment,this);
        }
    }


}
