package com.android.gridviewproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Context mContext;
    private GridView grid_photo;
    private BaseAdapter mAdapter = null;
    private ArrayList<Icon> mData = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = MainActivity.this;
        grid_photo = (GridView) findViewById(R.id.grid);

        mData = new ArrayList<Icon>();
        mData.add(new Icon(R.mipmap.iv_icon_1, "图书"));
        mData.add(new Icon(R.mipmap.iv_icon_2, "短信"));
        mData.add(new Icon(R.mipmap.iv_icon_3, "联系人"));
        mData.add(new Icon(R.mipmap.iv_icon_4, "音乐"));
        mData.add(new Icon(R.mipmap.iv_icon_5, "电影"));
        mData.add(new Icon(R.mipmap.iv_icon_6, "天气"));
        mData.add(new Icon(R.mipmap.iv_icon_7, "浏览器"));
        mData.add(new Icon(R.mipmap.iv_icon_8, "时钟"));
        mData.add(new Icon(R.mipmap.iv_icon_9, "日历"));
        mData.add(new Icon(R.mipmap.iv_icon_10, "游戏"));
        mData.add(new Icon(R.mipmap.iv_icon_11, "相机"));

        mAdapter = new MyAdapter<Icon>(mData, R.layout.item_grid) {
            @Override
            public void bindView(ViewHolder holder, Icon obj) {
                holder.setImageResource(R.id.img_icon, obj.getiId());
                holder.setText(R.id.txt_icon, obj.getiName());
            }
        };

        grid_photo.setAdapter(mAdapter);

        grid_photo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mContext, "你点击了~" + position + "~项", Toast.LENGTH_SHORT).show();
            }
        });

    }

}