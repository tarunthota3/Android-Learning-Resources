package com.example.module3_start_activity_for_result;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        editText = (EditText)findViewById(R.id.editText);
        findViewById(R.id.send_result).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = editText.getText().toString();
                if(value == null || value.length() == 0){
                    setResult(RESULT_CANCELED);
                }
                else{
                    Intent intent = new Intent();
                    intent.putExtra(MainActivity.VALUE_KEY, value);
                    setResult(RESULT_OK, intent);
                }
                finish();
            }
        });
    }
}
