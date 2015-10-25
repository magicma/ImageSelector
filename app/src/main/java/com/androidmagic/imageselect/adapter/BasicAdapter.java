package com.androidmagic.imageselect.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2015/10/24.
 */
public class BasicAdapter<T> extends BaseAdapter {
    protected List<T> list;
    protected Context mContext;

    //根据成员变量生成构造方法
    public BasicAdapter(Context mContext,List<T> list) {
        super();
        this.list = list;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {

        return list.size();
    }

    @Override
    public Object getItem(int position) {

        return list.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return null;
    }
}
