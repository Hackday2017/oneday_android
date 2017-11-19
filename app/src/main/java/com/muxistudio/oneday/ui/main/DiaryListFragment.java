package com.muxistudio.oneday.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.muxistudio.oneday.R;
import com.muxistudio.oneday.base.BaseFragment;
import com.muxistudio.oneday.ui.edit.EditDiaryActivity;
import com.muxistudio.oneday.ui.main.adapter.DiaryListAdapter;

/**
 * Created by fengminchao on 17/11/18
 */

public class DiaryListFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    private Toolbar mToolbar;
    private ImageView mIvAddButton;
    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;
    private DiaryListAdapter mDiaryListAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diarylist, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mToolbar = view.findViewById(R.id.toolbar);
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mIvAddButton = view.findViewById(R.id.iv_add);

        mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mDiaryListAdapter = new DiaryListAdapter();
        mRecyclerView.setAdapter(mDiaryListAdapter);

        mToolbar.setNavigationIcon(R.drawable.ic_menu_white_24dp);
//        ActionBar actionBar = getActivity().getActionBar();
        ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
        mIvAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditDiaryActivity.startActivity(getActivity());
            }
        });
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
