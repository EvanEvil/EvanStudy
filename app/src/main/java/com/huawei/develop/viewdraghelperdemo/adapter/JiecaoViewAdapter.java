package com.huawei.develop.viewdraghelperdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.huawei.develop.viewdraghelperdemo.R;
import com.huawei.develop.viewdraghelperdemo.bean.JiecaoBean;

import java.util.List;

/**
 * Created by Evan on 2016/11/8.
 */
public class JiecaoViewAdapter extends BaseAdapter {
    private List<JiecaoBean> list;
    private Context mContext;

    public JiecaoViewAdapter(List<JiecaoBean> list,Context context) {
        this.list = list;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(mContext,R.layout.item_jiecaoview,null);

        return view;
    }
}
