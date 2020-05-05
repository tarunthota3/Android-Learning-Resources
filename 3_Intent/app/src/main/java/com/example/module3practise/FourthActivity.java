package com.example.module3practise;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Toast;

public class FourthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
            if(getIntent() != null && getIntent().getExtras() != null){
//            Toast.makeText(this, "Name: " + getIntent().getExtras().getString(MainActivity.NAME_KEY) + ", Age: " +
//                        getIntent().getExtras().getString(MainActivity.AGE_KEY), Toast.LENGTH_SHORT).show();
//            User user = (User) getIntent().getExtras().getSerializable(MainActivity.USER_KEY);
//            Toast.makeText(this, user.toString(),Toast.LENGTH_SHORT).show();

            Person person = getIntent().getExtras().getParcelable(MainActivity.PERSON_KEY);
            Toast.makeText(this,person.toString(),Toast.LENGTH_SHORT).show();
        }
    }

}
