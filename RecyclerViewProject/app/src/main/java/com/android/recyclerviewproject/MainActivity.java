package com.android.recyclerviewproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ViewTypeAdapter adapter = new ViewTypeAdapter();
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            datas.add("位置是" + i);
        }
        adapter.setmDatas(datas);

        recyclerView.setAdapter(adapter);

    }
}