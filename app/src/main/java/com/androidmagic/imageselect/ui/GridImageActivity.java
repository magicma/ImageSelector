package com.androidmagic.imageselect.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

import com.androidmagic.imageselect.R;
import com.androidmagic.imageselect.adapter.GridImageAdapter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GridImageActivity extends Activity {

    private GridView gv_image;
    private TextView tv_choose_dir;
    private TextView tv_total_count;
    private String filePath;
    private List<String> images;
    private GridImageAdapter adapter;
    private String name;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_image);

        filePath = getIntent().getStringExtra("filePath");
        name = getIntent().getStringExtra("name");
        count = getIntent().getIntExtra("count", 0);
        initView();
        getImages();
        initData();

    }

    private void initView() {
        gv_image = (GridView) findViewById(R.id.gv_image);
        tv_choose_dir = (TextView) findViewById(R.id.tv_choose_dir);
        tv_total_count = (TextView) findViewById(R.id.tv_total_count);
    }

    private void getImages() {
        images = getAllImagePathsByFolder(filePath);
    }

    private void initData() {
        if (adapter == null) {
            adapter = new GridImageAdapter(GridImageActivity.this, images);
            gv_image.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
        tv_choose_dir.setText(name);
        tv_total_count.setText(count + "张");
    }

    /**
     * 获取指定路径下的所有图片文件。
     */
    private ArrayList<String> getAllImagePathsByFolder(String folderPath) {
        File folder = new File(folderPath);
        String[] allFileNames = folder.list();
        if (allFileNames == null || allFileNames.length == 0) {
            return null;
        }

        ArrayList<String> imageFilePaths = new ArrayList<String>();
        for (int i = allFileNames.length - 1; i >= 0; i--) {
            if (isImage(allFileNames[i])) {
                imageFilePaths.add(folderPath + File.separator
                        + allFileNames[i]);
            }
        }
        return imageFilePaths;
    }

    /**
     * 判断该文件是否是一个图片。
     */
    public static boolean isImage(String fileName) {
        return fileName.endsWith(".jpg") || fileName.endsWith(".jpeg")
                || fileName.endsWith(".png");
    }

}
