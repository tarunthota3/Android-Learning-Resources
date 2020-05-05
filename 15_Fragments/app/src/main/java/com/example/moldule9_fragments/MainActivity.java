package com.example.moldule9_fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AFragment.OnFragmentTextChange {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new AFragment(), "tag_AFragement")
                .commit();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new AFragment(), "tag_AFragement_1")
                .commit();

        RadioGroup rg = findViewById(R.id.radioGroup);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

//                AFragment af = (AFragment) getSupportFragmentManager().findFragmentById(R.id.fragment2);
                AFragment af = (AFragment) getSupportFragmentManager().findFragmentByTag("tag_AFragement");

                if(checkedId == R.id.radioButtonRed){
                    af.changeColor(Color.RED);
                }
                else if(checkedId == R.id.radioButtonGreen){
                    af.changeColor(Color.GREEN);
                }
                else if(checkedId == R.id.radioButtonBlue){
                    af.changeColor(Color.BLUE);
                }
            }
        });
    }

    @Override
    public void onTextChanged(String text) {
        TextView tv = findViewById(R.id.textView);
        tv.setText(text);
    }
}
