package com.muxistudio.oneday.ui.main.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.muxistudio.oneday.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fengminchao on 17/11/19
 */

public class SelectedLayout extends LinearLayout implements View.OnClickListener{

    @BindView(R.id.tv_first)
    TextView mTvFirst;
    @BindView(R.id.tv_second)
    TextView mTvSecond;
    @BindView(R.id.tv_third)
    TextView mTvThird;

    private View mLastSelectedView;

    private int selectPos = -1;

    public SelectedLayout(Context context) {
        super(context, null);
    }

    public SelectedLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    //set一个size为3的list
    public void setData(List<String> stringList){
        if (stringList == null){
            return;
        }
        mTvFirst.setText(stringList.get(0));
        mTvSecond.setText(stringList.get(1));
        mTvThird.setText(stringList.get(2));
    }

    public void setData(String[] strings){
        if (strings == null){
            return;
        }
        mTvFirst.setText(strings[0]);
        mTvSecond.setText(strings[1]);
        mTvThird.setText(strings[2]);
    }

    private void init() {
        View view = inflate(getContext(), R.layout.layout_select, this);
        ButterKnife.bind(this,view);
        mTvFirst.setOnClickListener(this);
        mTvSecond.setOnClickListener(this);
        mTvThird.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        onSelectView(view);
        if (id == R.id.tv_first){
            selectPos = 0;
        }else if (id == R.id.tv_second){
            selectPos = 1;
        }else if (id == R.id.tv_third){
            selectPos = 2;
        }
    }

    public int getSelectPos(){
        return selectPos;
    }

    private void onSelectView(View view) {
        if (mLastSelectedView != null){
            mLastSelectedView.setSelected(false);
        }
        mLastSelectedView = view;
        mLastSelectedView.setSelected(true);
    }
}
