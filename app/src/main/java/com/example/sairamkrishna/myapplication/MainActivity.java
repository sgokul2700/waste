package com.example.sairamkrishna.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;


public class MainActivity extends Activity {
    Button b1,b2;
    EditText ed1,ed2;
    DatabaseHelper databaseHelper;
    TextView tx1;
    int counter = 3;
    String inputPassword,inputUserType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHelper = new DatabaseHelper(this);
        b1 = (Button)findViewById(R.id.button);
        ed1 = (EditText)findViewById(R.id.editText);
        ed2 = (EditText)findViewById(R.id.editText2);

        b2 = (Button)findViewById(R.id.button2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ed1.getText().toString().matches("")) {
                    Toast.makeText(getApplicationContext(), "Please enter Username Id", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (ed1.getText().toString().matches("")) {
                    Toast.makeText(getApplicationContext(), "Please enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(ed1.getText().toString().equals("admin") &&
                        ed2.getText().toString().equals("admin")) {
                    Intent i=new Intent(MainActivity.this, MainAdmin.class);
                    startActivity(i);
                }else if(ed1.getText().toString().equals("user") &&
                        ed2.getText().toString().equals("user")){
                    Intent f=new Intent(MainActivity.this, MainUser.class);
                    startActivity(f);
                }
                else{
                    Cursor res = databaseHelper.getLoginData(ed1.getText().toString());
                    if(res.getCount() == 0){ //if no data is present getCount() will be 0
                        Toast.makeText(getApplicationContext(), "Incorrect Username", Toast.LENGTH_SHORT).show();
                        return;}
                        res.moveToNext();
                    inputPassword = res.getString(1);
                    inputUserType = res.getString(2);
                    if(ed2.getText().toString().equals(inputPassword)){
                        if(inputUserType.equals("admin")){
                            Intent i=new Intent(MainActivity.this, MainAdmin.class);
                            startActivity(i);
                        }
                        else if(inputUserType.equals("user")){
                            Intent f=new Intent(MainActivity.this, MainUser.class);
                            startActivity(f);
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Incorrect Password",Toast.LENGTH_SHORT).show();
                    }
                }
//                if(ed1.getText().toString().equals("admin") &&
//                        ed2.getText().toString().equals("admin")) {
//                    Intent i=new Intent(MainActivity.this, MainAdmin.class);
//                    startActivity(i);
//                }else if(ed1.getText().toString().equals("user") &&
//                        ed2.getText().toString().equals("user")){
//                    Intent f=new Intent(MainActivity.this, MainUser.class);
//                    startActivity(f);
//                }
//                else{Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();}
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}