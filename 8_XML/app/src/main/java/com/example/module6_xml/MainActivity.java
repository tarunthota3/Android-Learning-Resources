package com.example.module6_xml;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParserException;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isConnected()){
                    Toast.makeText(MainActivity.this, "Internet present", Toast.LENGTH_SHORT).show();
                    new GetSimpleAsync().execute("http://api.theappsdr.com/xml/");
                }
                else{
                    Toast.makeText(MainActivity.this, "No Internet", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private boolean isConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo == null || !networkInfo.isConnected() ||
                (networkInfo.getType() != ConnectivityManager.TYPE_WIFI
                        && networkInfo.getType() != ConnectivityManager.TYPE_MOBILE)) {
            return false;
        }
        return true;
    }

    private class GetSimpleAsync extends AsyncTask<String, Void, ArrayList<Person>> {
        @Override
        protected ArrayList<Person> doInBackground(String... params) {
            HttpURLConnection connection = null;
            ArrayList<Person> result = null;
            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
//                    result = PersonParser.PersonsSAXParser.parsePersons(connection.getInputStream());
                    result = PersonParser.PersonsPullParser.parsePersons(connection.getInputStream());
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
//            catch (SAXException e) {
//                e.printStackTrace();
//            }
            catch (XmlPullParserException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
            }
            return result;
        }

        @Override
        protected void onPostExecute(ArrayList<Person> result) {
            if (result != null) {
                Log.d("demo", result.toString());
            } else {
                Log.d("demo", "null result");
            }
        }
    }
}
