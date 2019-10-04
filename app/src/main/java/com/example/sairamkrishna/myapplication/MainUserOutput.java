package com.example.sairamkrishna.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainUserOutput extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    String area_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_user_output);
        Intent intent = getIntent();
        area_id = intent.getStringExtra("AREA_ID");
        databaseHelper = new DatabaseHelper(this);

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
                Cursor res = databaseHelper.getAreaData(area_id);
                if(res.getCount() == 0){ //if no data is present getCount() will be 0
                    showMessage("Error","No data available!");
                    return;}
                StringBuffer buffer = new StringBuffer();   //To print
                while(res.moveToNext()){
                    buffer.append("Area ID : "+res.getString(0)+"\n");
                    buffer.append("Area Name : "+res.getString(1)+"\n");
                    buffer.append("Taluk ID : "+res.getString(2)+"\n");
                    buffer.append("Town ID : "+res.getString(3)+"\n");
                }
                showMessage("Data",buffer.toString());
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = databaseHelper.getWasteData(area_id);
                if(res.getCount() == 0){ //if no data is present getCount() will be 0
                    showMessage("Error","No data available!");
                    return;}
                StringBuffer buffer = new StringBuffer();   //To print
                while(res.moveToNext()){
                    buffer.append("Waste ID : "+res.getString(0)+"\n");
                    buffer.append("Waste Type : "+res.getString(1)+"\n");
                    buffer.append("Area ID : "+res.getString(2)+"\n");
                    buffer.append("Level : "+res.getString(3)+"\n");

                }
                showMessage("Data",buffer.toString());
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = databaseHelper.getGrievanceData(area_id);
                if(res.getCount() == 0){ //if no data is present getCount() will be 0
                    showMessage("Error","No data available!");
                    return;}
                StringBuffer buffer = new StringBuffer();   //To print
                while(res.moveToNext()){
                    buffer.append("Grievance ID : "+res.getString(0)+"\n");
                    buffer.append("Area ID : "+res.getString(1)+"\n");
                    buffer.append("Reason : "+res.getString(2)+"\n");
                    buffer.append("ID : "+res.getString(3)+"\n");

                }
                showMessage("Data",buffer.toString());
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = databaseHelper.getSuggestionData();
                if(res.getCount() == 0){ //if no data is present getCount() will be 0
                    showMessage("Error","No data available!");
                    return;}
                StringBuffer buffer = new StringBuffer();   //To print
                while(res.moveToNext()){
                    buffer.append("Level : "+res.getString(0)+"\n");
                    buffer.append("Method : "+res.getString(1)+"\n");
                    buffer.append("Waste ID : "+res.getString(2)+"\n");
                    buffer.append("Solution : "+res.getString(3)+"\n");

                }
                showMessage("Data",buffer.toString());
            }
        });

//        b1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(MainUserOutput.this, MainAdmin1.class);
//                startActivity(i);
//            }
//        });
//        b2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent j = new Intent(MainUserOutput.this, MainAdmin2.class);
//                startActivity(j);
//            }
//        });
//        b3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent k = new Intent(MainUserOutput.this, MainAdmin3.class);
//                startActivity(k);
//            }
//        });
//        b4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent k = new Intent(MainUserOutput.this, MainAdmin4.class);
//                startActivity(k);
//            }
//        });
//        b5.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent k = new Intent(MainUserOutput.this, MainAdmin5.class);
//                startActivity(k);
//            }
//        });
//        b6.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent k = new Intent(MainUserOutput.this, MainAdmin6.class);
//                startActivity(k);
//            }
//        });
//        b7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent k = new Intent(MainUserOutput.this, MainUserOutput.class);
//                startActivity(k);
//            }
//        });
    }
    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);    //Used to cancel after showing the message
        builder.setTitle(title);    //Set the title of the message
        builder.setMessage(message);    //Set the message
        builder.show(); // to display the message
    }
}