package com.example.sairamkrishna.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);

        Button b1 = (Button)findViewById(R.id.button3);
        Button  b2 = (Button)findViewById(R.id.button4);
        Button  b3 = (Button)findViewById(R.id.button5);
        Button  b4 = (Button)findViewById(R.id.button6);
        Button  b5 = (Button)findViewById(R.id.button7);
        Button  b6 = (Button)findViewById(R.id.button8);
        Button  b7 = (Button)findViewById(R.id.button9);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainAdmin.this, MainAdmin1.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(MainAdmin.this, MainAdmin2.class);
                startActivity(j);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(MainAdmin.this, MainAdmin3.class);
                startActivity(k);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(MainAdmin.this, MainAdmin4.class);
                startActivity(k);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(MainAdmin.this, MainAdmin5.class);
                startActivity(k);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(MainAdmin.this, MainAdmin6.class);
                startActivity(k);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(MainAdmin.this, MainUser.class);
                startActivity(k);
            }
        });
    }
}
