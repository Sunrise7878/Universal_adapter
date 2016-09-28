package com.gcy.universal_adapter.utils;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by gcy71 on 2016/9/26.
 */

public class BaseViewHolder {

    /*用于存储各类控件的容器*/
    private SparseArray<View> mViews;

    private View mConvertView;

    private int mPosition;

    public BaseViewHolder(Context context , ViewGroup parent , int layoutID , int position) {
        mViews = new SparseArray<View>();
        mPosition = position;
        mConvertView = LayoutInflater.from(context).inflate(layoutID , parent ,false);
        mConvertView.setTag(this);
    }

    /*抛出一个get方法,不用每次都new一个ViewHolder,可通过此方法来获取一个*/
    public static BaseViewHolder getViewHolder(Context context , ViewGroup parent , int layoutID , int position , View convertView){
        if(convertView == null){
            return new BaseViewHolder(context , parent , layoutID , position);
        }else{
            BaseViewHolder holder = (BaseViewHolder) convertView.getTag();
            holder.mPosition = position;
            return holder;
        }
    }

    /*用户可通过View的ID来获取控件，替代传统Adapter中利用convertView.findViewByID()获取控件*/
    public <T extends View> T getView(int ViewID){
        View view = mViews.get(ViewID);
        if(view == null){
            view = mConvertView.findViewById(ViewID);
            mViews.put(ViewID , view);
        }
        return (T) view;
    }

    public View getConvertView() {
        return mConvertView;
    }

    /**
     * 辅助方法，减少用户为控件设置值的代码
     */
    //返回值设置为BaseViewHolder类型是为了实现链式编程
    public BaseViewHolder setText2TextView(int ViewID , String text){
        ((TextView)getView(ViewID)).setText(text);
        return this;
    }
}
