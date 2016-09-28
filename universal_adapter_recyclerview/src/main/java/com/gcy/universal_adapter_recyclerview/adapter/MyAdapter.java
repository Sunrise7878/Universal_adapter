package com.gcy.universal_adapter_recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gcy.universal_adapter_recyclerview.Entity.Bean;
import com.gcy.universal_adapter_recyclerview.R;

import java.util.List;

/**
 * Created by gcy71 on 2016/9/28.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context mContext;
    private List<Bean> mDatas;
    private LayoutInflater mInflater;

    public MyAdapter(Context context , List<Bean> datas) {
        this.mContext = context;
        this.mDatas = datas;
        this.mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(mInflater.inflate(R.layout.item_recyclerview, parent, false)) {
            @Override
            public void getViews(View itemView) {
                mTilte = (TextView) itemView.findViewById(R.id.id_title);
                mInfo = (TextView) itemView.findViewById(R.id.id_info);
                mTime = (TextView) itemView.findViewById(R.id.id_time);
            }
        };
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mTilte.setText(mDatas.get(position).getTitle());
        holder.mInfo.setText(mDatas.get(position).getInfo());
        holder.mTime.setText(mDatas.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    abstract class MyViewHolder extends RecyclerView.ViewHolder{
        TextView mTilte;
        TextView mInfo;
        TextView mTime;
        public MyViewHolder(View itemView) {
            super(itemView);
            getViews(itemView);
            /*mTilte = (TextView) itemView.findViewById(R.id.id_title);
            mInfo = (TextView) itemView.findViewById(R.id.id_info);
            mTime = (TextView) itemView.findViewById(R.id.id_time);*/
        }

        public abstract void getViews(View itemView);
    }


}
