package com.example.sairamkrishna.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainAdmin5 extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    String s1,s2,s3;
    EditText ev1,ev2,ev3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin5);
        ev1=(EditText) findViewById(R.id.textview4);
        ev2=(EditText) findViewById(R.id.textview5);
        ev3=(EditText) findViewById(R.id.textview6);
        databaseHelper = new DatabaseHelper(this);
        Button b1 = (Button)findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1 = ev1.getText().toString();
                s2 = ev2.getText().toString();
                s3 = ev3.getText().toString();
                if (s1.matches("")) {
                    Toast.makeText(getApplicationContext(), "Please enter Town Id", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (s2.matches("")) {
                    Toast.makeText(getApplicationContext(), "Please enter Taluk Id", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (s3.matches("")) {
                    Toast.makeText(getApplicationContext(), "Please enter Town", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    boolean test = databaseHelper.insertTalukData(s2, s3, s1);
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
