package com.example.module7_part2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "demo";
    ArrayList<Email> emails = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emails.add(new Email("Hi","Summary1","bsmith1@test.com"));
        emails.add(new Email("Hiii","Summary2","bsmith2@test.com"));
        emails.add(new Email("Hello","Summary3","bsmith3@test.com"));
        emails.add(new Email("Wassup","Summary4","bsmith4@test.com"));
        emails.add(new Email("Hola","Summary5","bsmith5@test.com"));
        emails.add(new Email("Greetings","Summary6","bsmith6@test.com"));
        emails.add(new Email("Hey","Summary7","bsmith7@test.com"));
        emails.add(new Email("Hey","Summary8","bsmith8@test.com"));
        emails.add(new Email("Hey","Summary9","bsmith9@test.com"));
        emails.add(new Email("Hey","Summary10","bsmith10@test.com"));
        emails.add(new Email("Hey","Summary11","bsmith11@test.com"));
        emails.add(new Email("Hey","Summary12","bsmith12@test.com"));


        ListView listView = (ListView) findViewById(R.id.listView);
        EmailAdapter adapter = new EmailAdapter(this, R.layout.email_item,emails);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "Clicked item: " + position );
            }
        });

    }
}
