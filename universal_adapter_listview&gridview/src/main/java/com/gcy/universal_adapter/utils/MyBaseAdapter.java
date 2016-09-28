package com.gcy.universal_adapter.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.gcy.universal_adapter.R;

import java.util.List;

/**
 * Created by gcy71 on 2016/9/27.
 */

public abstract class MyBaseAdapter<T> extends BaseAdapter {

    private Context mContext;
    private List<T> mDatas;
    private LayoutInflater mInflater;

    public MyBaseAdapter(Context context , List<T> datas) {
        this.mContext = context;
        this.mDatas = datas;
        this.mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseViewHolder viewHolder = BaseViewHolder.getViewHolder(mContext , parent , R.layout.item_listview , position , convertView);
        convert(viewHolder , mDatas.get(position));
        return viewHolder.getConvertView();
    }

    public abstract void convert(BaseViewHolder viewHolder , T t);
}
