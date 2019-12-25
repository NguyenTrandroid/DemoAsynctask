package com.example.demoasynctask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity implements ILoadDataComplete {
    List<Item> itemList;
    Button button;
    RecyclerView rvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        itemList = new ArrayList<>();
        init();
        DataManager.getInstance(this).startLoadJson();

    }

    private void init() {
        rvTitle = (RecyclerView)findViewById(R.id.rvTitle);

    }

    @Override
    public void onComplete(List<Item> itemList) {
        TitleAdapter titleAdapter = new TitleAdapter(MainActivity.this, itemList);
        rvTitle.setLayoutManager(new GridLayoutManager(this, 1));
        rvTitle.setAdapter(titleAdapter);


    }
}
