package com.example.module9_multifragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements FirstFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new FirstFragment(), "first")
                .commit();
    }

    @Override
    public void gotoNextFragement() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new SecondFragment(), "second")
//                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onBackPressed() {
        Log.d("demo", "onBackPressed: " + getSupportFragmentManager().getBackStackEntryCount());

        if(getSupportFragmentManager().getBackStackEntryCount() > 0){
            getSupportFragmentManager().popBackStack();
        }
        else{
            super.onBackPressed();
        }
    }
}
