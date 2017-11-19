package com.muxistudio.oneday.ui.edit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.muxistudio.oneday.R;
import com.muxistudio.oneday.base.BaseActivity;
import com.muxistudio.oneday.ui.main.view.SelectedLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fengminchao on 17/11/18
 */

public class EditDiaryActivity extends BaseActivity {

    @BindView(R.id.tv_date)
    TextView mTvDate;
    @BindView(R.id.iv_exit)
    ImageView mIvExit;
    @BindView(R.id.iv_done)
    ImageView mIvDone;
    @BindView(R.id.et_title)
    AppCompatEditText mEtTitle;
    @BindView(R.id.tv_text_num)
    TextView mTvTextNum;
    @BindView(R.id.action_bar_layout)
    RelativeLayout mActionBarLayout;
    @BindView(R.id.layout_first_select)
    SelectedLayout mLayoutFirstSelect;
    @BindView(R.id.layout_second_select)
    SelectedLayout mLayoutSecondSelect;
    @BindView(R.id.layout_third_select)
    SelectedLayout mLayoutThirdSelect;
    @BindView(R.id.layout_four_select)
    SelectedLayout mLayoutFourSelect;
    @BindView(R.id.et_note1)
    EditText mEtNote1;
    @BindView(R.id.et_note2)
    EditText mEtNote2;
    @BindView(R.id.et_note3)
    EditText mEtNote3;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, EditDiaryActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_diary);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        mIvExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        mIvDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveDiary();
            }
        });
        
    }

    private void saveDiary() {

    }
}
