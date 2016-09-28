package com.gcy.universal_adapter_recyclerview.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;


import java.util.List;


/**
 * Created by gcy71 on 2016/9/28.
 */

public abstract class MyBaseAdapter<T> extends RecyclerView.Adapter<BaseViewHolder> {

    private int LayoutID;
    private Context mContext;
    private List<T> mDatas;

    public MyBaseAdapter(int layoutID, Context mContext , List<T> datas) {
        this.LayoutID = layoutID;
        this.mContext = mContext;
        this.mDatas = datas;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseViewHolder holder = new BaseViewHolder(LayoutInflater.from(mContext).inflate(LayoutID, parent , false));
        return holder;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        blindViewHolder(holder , mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public abstract void blindViewHolder(BaseViewHolder holder , T t);
}
