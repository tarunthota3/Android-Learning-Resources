package com.example.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyAdapter.InteractWithMainActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter rv_adapter;
    RecyclerView.LayoutManager rv_layoutManager;
    ArrayList<User> users;
    String TAG = "demo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        users = new ArrayList<User>();

        for (int i=0;i<10;i++){
            User us = new User("name "+i, "email@"+i,"address "+i);
            users.add(us);
        }
        recyclerView = findViewById(R.id.rv_users);

        recyclerView.setHasFixedSize(true);

        rv_layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(rv_layoutManager);

        rv_adapter = new MyAdapter(users, this);
        recyclerView.setAdapter(rv_adapter);


    }

    @Override
    public void deleteItem(int position) {
        users.remove(position);
        rv_adapter.notifyDataSetChanged();
    }
}
