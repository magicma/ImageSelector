package com.androidmagic.imageselect.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidmagic.imageselect.R;
import com.androidmagic.imageselect.bean.ImageForder;
import com.androidmagic.imageselect.utils.ImageLoader;

import java.util.List;


/**
 * Created by Administrator on 2015/10/24.
 */
public class ForderAdapter extends BasicAdapter<ImageForder> {

    public ForderAdapter(Context mContext, List<ImageForder> list) {
        super(mContext, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.list_dir_item, null);
        }

        ViewHolder horder = ViewHolder.getHolder(convertView);

        ImageForder imageForder = list.get(position);
        ImageLoader.getInstance().loadImage(imageForder.getFirstImagePath(), horder.iv_item_image);
        horder.tv_item_name.setText(imageForder.getName() + "");
        horder.tv_item_count.setText(imageForder.getCount() + "");

        return convertView;
    }

    static class ViewHolder {
        ImageView iv_item_image;
        TextView tv_item_name, tv_item_count;

        public ViewHolder(View convertView) {
            iv_item_image = (ImageView) convertView
                    .findViewById(R.id.iv_item_image);
            tv_item_name = (TextView) convertView
                    .findViewById(R.id.tv_item_name);
            tv_item_count = (TextView) convertView
                    .findViewById(R.id.tv_item_count);

        }

        public static ViewHolder getHolder(View convertView) {
            ViewHolder holder = (ViewHolder) convertView.getTag();
            if (holder == null) {
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            }
            return holder;
        }
    }
}
