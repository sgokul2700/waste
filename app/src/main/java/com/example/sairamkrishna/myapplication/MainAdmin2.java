package com.example.sairamkrishna.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainAdmin2 extends AppCompatActivity {
    String s1,s2,s3;
    EditText ev1,ev2,ev3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin2);
        ev1=(EditText) findViewById(R.id.textview4);
        ev2=(EditText) findViewById(R.id.textview5);
        ev3=(EditText) findViewById(R.id.textview6);
        s1 = ev1.getText().toString();
        s2 = ev2.getText().toString();
        s3 = ev3.getText().toString();
    }
}
