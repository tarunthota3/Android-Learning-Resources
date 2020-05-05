package com.example.module3_practise_alertdialogs;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    CharSequence[] items = {"Red", "Green", "Blue", "Yellow"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ProgressBar progressBar = new ProgressBar(MainActivity.this,null);
//        progressBar

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Pick a color")
//                .setMessage("Are you Sure?")
//                .setItems(items, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Log.d("selected",""+items[which]);
//                    }
//                })
                .setCancelable(false)
                .setMultiChoiceItems(items, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        Log.d("selected",items[which] + " is " + isChecked);
                    }
                })
//                .setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Log.d("selected",""+items[which]);
//                    }
//                })
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("selected","Clicked ok");
                    }
                });
//                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Log.d("demo","Clicked OK");
//                    }
//                })
//                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Log.d("demo","Clicked Cancel");
//                    }
//                });

        final AlertDialog alert = builder.create();
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert.show();

            }
        });
    }
}
