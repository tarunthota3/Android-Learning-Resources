package com.example.module4_thread_communication_using_handler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;

public class progressBar_example extends AppCompatActivity {
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar_example);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setProgress(75);

    }
}
