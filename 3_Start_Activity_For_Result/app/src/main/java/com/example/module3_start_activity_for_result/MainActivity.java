package com.example.module3_start_activity_for_result;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final int REQ_CODE = 100;
    public static final String VALUE_KEY = "value";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.go_to_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivityForResult(intent, REQ_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CODE) {
            if (resultCode == RESULT_OK) {
                String value = data.getExtras().getString(VALUE_KEY);
                Log.d("demo", "Value received: " + value);
            } else if (resultCode == RESULT_CANCELED) {
                Log.d("demo", "No Value REceived");
            }
        }
    }
}
