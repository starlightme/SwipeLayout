package com.example.jimmy66.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private List<Item> mDatas;
    private ItemAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.list_view);
        mDatas = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            Item item = new Item();
            item.raw_content = "Test" + i;
            mDatas.add(item);
        }

        adapter = new ItemAdapter(MainActivity.this,mDatas);
        listView.setAdapter(adapter);

    }
}
