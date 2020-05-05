package com.example.module7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "demo";
//    String[] colors = {"Red","Blue","Green","White","Black","Yellow"};
//    Color[] colorObjects = {new Color("Red"),new Color("Blue "), new Color("Green"),
//                        new Color("White"),new Color("Black"),new Color("Yellow")};
    ArrayList<Color> data = new ArrayList<>();
    ArrayAdapter<Color> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data.add(new Color("Red"));
        data.add(new Color("Blue "));
        data.add(new Color("Green"));
        data.add(new Color("White"));
        data.add(new Color("Black"));
        data.add(new Color("Yellow"));

        ListView listView = (ListView) findViewById(R.id.listView);
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
//                                        android.R.id.text1, colors);
//        ArrayAdapter<Color> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
//                                        android.R.id.text1, colorObjects);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.d(TAG, "Clicked item: " + position + ", color: " + colors[position]);
//            }
//        });

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                android.R.id.text1, data);
        listView.setAdapter(adapter);
        findViewById(R.id.buttonAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.editText);
                adapter.add(new Color(editText.getText().toString()));
                adapter.notifyDataSetChanged();
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Color color = adapter.getItem(position);
                adapter.remove(color);
                adapter.notifyDataSetChanged();
                return false;
            }
        });

    }

    static class Color{
        String name;
        int hex;

        public Color(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return  name;
        }
    }
}
