package com.androidmagic.imageselect.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.androidmagic.imageselect.R;
import com.androidmagic.imageselect.utils.ImageLoader;

import java.util.LinkedList;
import java.util.List;

public class GridImageAdapter extends BasicAdapter<String> {

    /**
     * 用户选择的图片，存储为图片的完整路径
     */
    public static List<String> mSelectedImage = new LinkedList<String>();

    public GridImageAdapter(Context mContext, List<String> images) {
        super(mContext, images);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.grid_item, null);
        }

        final ViewHolder horder = ViewHolder.getHolder(convertView);

        final String path = list.get(position);

        ImageLoader.getInstance().loadImage(path, horder.iv_item_gridimage);
        horder.ib_item_select.setImageResource(R.mipmap.picture_unselected);
        horder.iv_item_gridimage.setColorFilter(null);
        horder.iv_item_gridimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 已经选择过该图片
                if (mSelectedImage.contains(path)) {
                    mSelectedImage.remove(path);
                    horder.ib_item_select.setImageResource(R.mipmap.picture_unselected);
                    horder.iv_item_gridimage.setColorFilter(null);
                } else {
                    //未选择过图片
                    mSelectedImage.add(path);
                    horder.ib_item_select.setImageResource(R.mipmap.pictures_selected);
                    horder.iv_item_gridimage.setColorFilter(Color.parseColor("#77000000"));
                }
            }
        });

        return convertView;
    }

    static class ViewHolder {
        ImageView iv_item_gridimage;
        ImageButton ib_item_select;

        public ViewHolder(View convertView) {
            iv_item_gridimage = (ImageView) convertView
                    .findViewById(R.id.iv_item_gridimage);
            ib_item_select = (ImageButton) convertView.findViewById(R.id.ib_item_select);
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
    
    OnImgSelectListener listener;
    
    public interface OnImgSelectListener() {
        void imgSelect();
    }
    
    public void setOnImgSelectListener(OnImgSelectListener listener) {
        this.listener = listener;
    }

}
