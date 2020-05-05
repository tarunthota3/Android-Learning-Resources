package com.example.module5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.os.AsyncTask;
import android.os.Bundle;
import android.telecom.Connection;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private String TAG = "demo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isConnected()){
                    Toast.makeText(MainActivity.this,"connected",Toast.LENGTH_SHORT).show();
                    new getDataAsync().execute("http://localhost:5005");
                }
                else{
                    Toast.makeText(MainActivity.this,"not connected",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private boolean isConnected(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        Network network = connectivityManager.getActiveNetwork();

        if(network == null){
//            networkinfo.isConnected()
//            networkInfo.getType() = ConnectivityManager.TYPE_WIFI typeMobile
            return false;
        }
        return true;
    }

    private class getDataAsync extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... params) {
            StringBuilder stringBuilder = new StringBuilder();
            HttpURLConnection connection = null;
            BufferedReader reader = null;
            String result = null;
            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                if(connection.getResponseCode() == HttpURLConnection.HTTP_OK){
                    reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String line = "";
                    while((line = reader.readLine()) != null){
                        stringBuilder.append(line);
                    }
//                  IOUtils.toString(connection.getInputStream(),"UTF8");
                    result = stringBuilder.toString();
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(connection != null){
                    connection.disconnect();
                }
                if(reader != null){
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            if(result != null){
                Log.d(TAG, "onPostExecute: " +result);
            }
            else{
                Log.d(TAG, "Null Result");
            }
        }
    }
}
