package com.muxistudio.oneday.ui.main.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.muxistudio.oneday.R;
import com.muxistudio.oneday.db.Diary;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengminchao on 17/11/18
 */

public class DiaryListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    // TODO: 17/11/18 数据结构待改
    private List<Diary> mDiaries = new ArrayList<>();

    public void setData(List<Diary> diaryList){
        mDiaries.clear();
        mDiaries.addAll(diaryList);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_diarylist,parent,false);
        return new DiaryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        DiaryViewHolder viewHolder = (DiaryViewHolder) holder;
        Picasso.with(viewHolder.itemView.getContext()).load("");
    }

    @Override
    public int getItemCount() {
        return mDiaries.size();
    }

    public static class DiaryViewHolder extends RecyclerView.ViewHolder {
        
        ImageView mImageView; 

        public DiaryViewHolder(View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.iv_diary);
        }
    }
}
