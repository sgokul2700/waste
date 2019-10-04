package com.example.sairamkrishna.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Vector;

public class MainUser extends AppCompatActivity {
    EditText ev;
    String area_id;
    DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_user);
        databaseHelper = new DatabaseHelper(this);

       Button  b1 = (Button)findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ev = (EditText) findViewById(R.id.editText);
                area_id=ev.getText().toString();
                Cursor res = databaseHelper.checkAreaData(area_id);
                if(res.getCount() == 0){ //if no data is present getCount() will be 0
                    Toast.makeText(getApplicationContext(), "Invalid Area ID", Toast.LENGTH_SHORT).show();
                    return;}
                /*Vector vector = new Vector();
                while(res.moveToNext()){
                    vector.add(res.getString(0));
                }/*
                    /*
                StringBuffer buffer = new StringBuffer();   //To print
                while(res.moveToNext()){
                    buffer.append("Area ID : "+res.getString(0)+"\n");
                    buffer.append("Taluk ID : "+res.getString(1)+"\n");
                    buffer.append("Area Name : "+res.getString(2)+"\n");
                }
                showMessage("Data",buffer.toString());
                */
                //if(vector.contains(area_id)){
                    Intent i=new Intent(MainUser.this, MainUserOutput.class);
                i.putExtra("AREA_ID",area_id);
                startActivity(i);}
          //  }
            });

    }

}
