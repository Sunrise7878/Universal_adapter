package com.gcy.universal_adapter_recyclerview.utils;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;


/**
 * Created by gcy71 on 2016/9/28.
 */

public class BaseViewHolder extends RecyclerView.ViewHolder {

    /*用于存储各类控件的容器*/
    private SparseArray<View> mViews;

    private View itemView;


    public BaseViewHolder(View itemView) {
        super(itemView);
        mViews = new SparseArray<View>();
        this.itemView = itemView;
        itemView.setTag(this);
    }

    //通过ViewID在容器中获取控件，若在容器中没有该控件就通过ID获取，然后存储到容器中
    public <T extends View> T getView(int ViewID){
        View view = mViews.get(ViewID);
        if(view == null){
            view = itemView.findViewById(ViewID);
            mViews.put(ViewID , view);
        }
        return (T) view;
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
