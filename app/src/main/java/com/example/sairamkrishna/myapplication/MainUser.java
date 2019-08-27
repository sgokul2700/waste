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
                Cursor res = databaseHelper.getAreaData(area_id);
                if(res.getCount() == 0){ //if no data is present getCount() will be 0
                    showMessage("Error","No data found");
                    return;}
                StringBuffer buffer = new StringBuffer();   //To print
                while(res.moveToNext()){
                    buffer.append("Area ID : "+res.getString(0)+"\n");
                    buffer.append("Taluk ID : "+res.getString(1)+"\n");
                    buffer.append("Area Name : "+res.getString(2)+"\n");
                }
                showMessage("Data",buffer.toString());
                /*Intent i=new Intent(MainUser.this, MainUserOutput.class);
                i.putExtra("AREA_ID",area_id);
                startActivity(i);*/
            }
            });

    }
    public void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);    //Used to cancel after showing the message
        builder.setTitle(title);    //Set the title of the message
        builder.setMessage(message);    //Set the message
        builder.show(); // to display the message
    }
}
