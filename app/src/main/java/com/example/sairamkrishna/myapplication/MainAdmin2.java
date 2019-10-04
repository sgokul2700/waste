package com.example.sairamkrishna.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainAdmin2 extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    String s1,s2,s3,s4;
    EditText ev1,ev2,ev3,ev4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin2);
        ev1=(EditText) findViewById(R.id.textview4);
        ev2=(EditText) findViewById(R.id.textview5);
        ev3=(EditText) findViewById(R.id.textview6);
        ev4=(EditText) findViewById(R.id.textview7);
        databaseHelper = new DatabaseHelper(this);
        Button b1 = (Button)findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1 = ev1.getText().toString();
                s2 = ev2.getText().toString();
                s3 = ev3.getText().toString();
                s4 = ev4.getText().toString();
                if (s1.matches("")) {
                    Toast.makeText(getApplicationContext(), "Please enter Waste Id", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (s2.matches("")) {
                    Toast.makeText(getApplicationContext(), "Please enter Waste Type", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (s3.matches("")) {
                    Toast.makeText(getApplicationContext(), "Please enter Level", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (s4.matches("")) {
                    Toast.makeText(getApplicationContext(), "Please enter Area Id", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    boolean test = databaseHelper.insertWasteData(s1, s2, s4, s3);
                    if (test)
                        Toast.makeText(getApplicationContext(),
                                "Inserted", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(getApplicationContext(),
                                "Not Inserted", Toast.LENGTH_SHORT).show();
                }
                }});
            }
    }
