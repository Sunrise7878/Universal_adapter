package com.gcy.universal_adapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.gcy.universal_adapter.utils.ListViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Bean> mDatas;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initListView();
    }

    private void initListView() {
        mListView = (ListView) findViewById(R.id.id_listview);
        mListView.setAdapter(new ListViewAdapter(this , mDatas));
    }

    private void initData() {
        mDatas = new ArrayList<Bean>();
        for(int i=1 ; i<=10 ; i++){
            mDatas.add(new Bean("我是标题 " + i, "Android打造ListView和GridView万能适配器" , "2016-09-27"));
        }
    }
}
