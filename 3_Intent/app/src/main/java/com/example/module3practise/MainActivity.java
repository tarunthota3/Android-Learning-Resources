package com.example.module3practise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static String NAME_KEY="Name";
    static String AGE_KEY="Age";
    static String USER_KEY ="USER";
    static String PERSON_KEY = "PERSON";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        RelativeLayout relativeLayout = new RelativeLayout(this);
//        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.MATCH_PARENT));
//        setContentView(relativeLayout);
//
////        TextView tv = new TextView(this);
////        tv.setText(R.string.hello_world);
////        tv.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.WRAP_CONTENT));
////        tv.setId(View.generateViewId());
////        relativeLayout.addView(tv);
////
////
////        Button bt = new Button(this);
////        bt.setText(R.string.button_text);
////        RelativeLayout.LayoutParams btlayoutparams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
////        btlayoutparams.addRule(RelativeLayout.BELOW,tv.getId());
////        bt.setLayoutParams(btlayoutparams);
////        relativeLayout.addView(bt);

//            findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
////                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
////                    startActivity(intent);
//                    Intent intent = new Intent("com.example.module3practise.intent.action.VIEW");
//                    intent.addCategory(Intent.CATEGORY_DEFAULT);
//                    startActivity(intent);
//                }
//            });

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, FourthActivity.class);
//                intent.putExtra(NAME_KEY,"Bob Smith");
//                intent.putExtra(AGE_KEY,"23");
//
//                User user = new User("Alice Smith",25);
//                intent.putExtra(USER_KEY,user);

//                intent.putExtra(PERSON_KEY, new Person("Rob Smith",23,"Charlotte"));
//                startActivity(intent);

//                Intent intent1 =  new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.uncc.edu"));
//                startActivity(intent1);

//                Intent intent2 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:8607942081"));
//                startActivity(intent2);
            }
        });
    }


}
