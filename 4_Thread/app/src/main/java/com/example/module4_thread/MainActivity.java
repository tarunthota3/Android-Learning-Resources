package com.example.module4_thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    ExecutorService threadpool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        threadpool = Executors.newFixedThreadPool(4);
        threadpool.execute(new DoWOrk());


        findViewById(R.id.button_Start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread = new Thread( new DoWOrk(), "Worker 1");
                thread.start();
            }
        });
    }
    class DoWOrk implements Runnable{

        @Override
        public void run() {
            Log.d("demo","Started Work");
            for(int i = 0; i < 100000; i++){
                for(int j =0; j < 1000000; j++ ){
                }
            }
            Log.d("demo","Ended Work");
        }
    }
}
