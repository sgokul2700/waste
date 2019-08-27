package com.example.sairamkrishna.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainUserOutput extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_user_output);
        String message = getIntent().getStringExtra("AREA_ID");
        TextView tv = (TextView) findViewById(R.id.textview4);
        tv.setText(message);
    }
}
