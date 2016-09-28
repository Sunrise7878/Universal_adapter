package com.gcy.universal_adapter.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.gcy.universal_adapter.Bean;
import com.gcy.universal_adapter.R;

import java.util.List;

/**
 * Created by gcy71 on 2016/9/27.
 */

public class MyAdapter extends BaseAdapter {
    private Context mContext;
    private List<Bean> mDatas;
    private LayoutInflater mInflater;
    public MyAdapter(Context context , List<Bean> datas){
        this.mContext = context;
        this.mDatas = datas;
        this.mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.item_listview , parent , false);
            viewHolder = new ViewHolder();

            viewHolder.mTilte = (TextView) convertView.findViewById(R.id.id_title);
            viewHolder.mInfo = (TextView) convertView.findViewById(R.id.id_info);
            viewHolder.mTime = (TextView) convertView.findViewById(R.id.id_time);
            Bean bean = mDatas.get(position);
            viewHolder.mTilte.setText(bean.getTitle());
            viewHolder.mInfo.setText(bean.getInfo());
            viewHolder.mTime.setText(bean.getTime());

            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
            Bean bean = mDatas.get(position);
            viewHolder.mTilte.setText(bean.getTitle());
            viewHolder.mInfo.setText(bean.getInfo());
            viewHolder.mTime.setText(bean.getTime());
        }
        return convertView;
    }

    class ViewHolder{
        TextView mTilte;
        TextView mInfo;
        TextView mTime;

    }
}
