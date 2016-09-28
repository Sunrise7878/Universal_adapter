package com.gcy.universal_adapter_recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gcy.universal_adapter_recyclerview.Entity.Bean;
import com.gcy.universal_adapter_recyclerview.utils.BaseViewHolder;
import com.gcy.universal_adapter_recyclerview.utils.DividerItemDecoration;
import com.gcy.universal_adapter_recyclerview.utils.MyBaseAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Bean> mDatas;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initRecyclerView();
    }

    private void initRecyclerView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        //此处我们使用匿名内部类的方式来为mRecyclerView设置Adapter
        mRecyclerView.setAdapter(new MyBaseAdapter<Bean>(R.layout.item_recyclerview , this , mDatas) {
            @Override
            public void blindViewHolder(BaseViewHolder holder, Bean bean) {
                holder.setText2TextView(R.id.id_title , bean.getTitle())
                        .setText2TextView(R.id.id_info , bean.getInfo())
                        .setText2TextView(R.id.id_time,bean.getTime());
            }
        });
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this , DividerItemDecoration.VERTICAL_LIST));
    }

    private void initData() {
        mDatas = new ArrayList<Bean>();
        for(int i=1 ; i<=10 ; i++){
            mDatas.add(new Bean("我是标题 " + i, "Android打造ListView和GridView万能适配器" , "2016-09-28"));
        }
    }
}
