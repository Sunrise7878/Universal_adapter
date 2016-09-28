package com.gcy.universal_adapter.utils;

        import android.content.Context;

        import com.gcy.universal_adapter.Bean;
        import com.gcy.universal_adapter.R;

        import java.util.List;

/**
 * Created by gcy71 on 2016/9/27.
 */

public class ListViewAdapter extends MyBaseAdapter<Bean> {
    public  ListViewAdapter(Context context , List<Bean> datas){
        super(context , datas);
    }
    @Override
    public void convert(BaseViewHolder viewHolder, Bean bean) {
        viewHolder.setText2TextView(R.id.id_title , bean.getTitle())
                .setText2TextView(R.id.id_info , bean.getInfo())
                .setText2TextView(R.id.id_time , bean.getTime());
    }
}
