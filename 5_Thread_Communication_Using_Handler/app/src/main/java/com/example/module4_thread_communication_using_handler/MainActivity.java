package com.example.module4_thread_communication_using_handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    Handler handler;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = (ProgressBar) findViewById(R.id.progressBar2);

            handler = new Handler(new Handler.Callback() {
                @Override
                public boolean handleMessage(@NonNull Message msg) {
                Log.d("demo","Message received: " + msg.obj);
                switch (msg.what){
                    case DoWOrk.STATUS_START:
                        Log.d("demo","stared");
                        progressBar.setProgress(0);
//                        progressBar.showContextMenu();
//                        progressBar = new ProgressBar(MainActivity.this);
//                        progressBar.setBackgroundColor(1);
//                        progressBar.setMax(100);
                        Log.d("demo","Starting......");
                        break;
                    case DoWOrk.STATUS_STOP:
                        Log.d("demo","stopped");
//                        progressBar.stopNestedScroll();
//                        progressBar.setVisibility(View.GONE);
                        Log.d("demo","Stopping......");
                        break;
                    case DoWOrk.STATUS_PROGRESS:
                        Log.d("demo","in progress");
                        progressBar.setProgress((Integer)msg.getData().getInt(DoWOrk.PROGRESS_KEY));
                        Log.d("demo","progress......" + msg.getData().getInt(DoWOrk.PROGRESS_KEY));
                        break;

                }

                return false;
            }
        });
        new Thread(new DoWOrk()).start();

//        Log.d("demo","ON create thread id is: " + Thread.currentThread().getId());
//
//        new DoWorkAsync().execute("Bob","Alice");

    }
    class DoWorkAsync extends AsyncTask<String, Integer, Double>{
        @Override
        protected void onPreExecute() {
            Log.d("demo","onPreExecute thread id is: " + Thread.currentThread().getId());

        }

        @Override
        protected void onPostExecute(Double aDouble) {
            Log.d("demo","onPostExecute thread id is: " + Thread.currentThread().getId());
            Log.d("demo","aDouble id is: " + aDouble);

        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            Log.d("demo","onProgressUpdate thread id is: " + Thread.currentThread().getId());
            Log.d("demo", "onProgressUpdate values: " + values[0]);

        }

        @Override
        protected Double doInBackground(String... strings) {
            for (String var: strings) {
                Log.d("demo","Params is: " + var.toString());
            }

            Log.d("demo","doInBackground thread id is: " + Thread.currentThread().getId());
            publishProgress(100);

            return 333.33;
        }
    }
    class DoWOrk implements Runnable{
        static final int STATUS_START = 0x00;
        static final int STATUS_PROGRESS = 0x01;
        static final int STATUS_STOP = 0x02;
        static final String PROGRESS_KEY = "PROGRESS";

        @Override
        public void run() {

            Message startMessage = new Message();
            startMessage.what = STATUS_START;
            handler.sendMessage(startMessage);

            Log.d("demo","Started Work");
            for(int i = 0; i < 100; i++){
                for(int j =0; j < 100000000; j++ ){
                }
                Message progressMessage = new Message();
                progressMessage.what = STATUS_PROGRESS;
                progressMessage.obj = (Integer) i;
                Bundle bundle = new Bundle();
                bundle.putInt(PROGRESS_KEY,(Integer)i);
                progressMessage.setData(bundle);
                handler.sendMessage(progressMessage);
            }
            Message stopMessage = new Message();
            stopMessage.what = STATUS_STOP;
            handler.sendMessage(stopMessage);
            Log.d("demo","Ended Work");
        }
    }
}
